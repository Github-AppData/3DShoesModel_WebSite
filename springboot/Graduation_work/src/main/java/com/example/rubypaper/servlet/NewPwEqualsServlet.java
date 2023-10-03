package com.example.rubypaper.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.crypt.PasswordHashingUtil;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NewPwEqualsServlet")
public class NewPwEqualsServlet extends HttpServlet{

	// 이 서블릿은 입력한 비밀번호 확인 서블릿 입니다.
	
	String New_Pw, New_Pw_same, input_id;
	User input_ids;
	Boolean isSame = false;
	Boolean isValid = false;
	
	PasswordHashingUtil passwordHashingUtil = new PasswordHashingUtil();
	String hashedPasswordValid, hashedPassword, salt;
	
	@Autowired
	UserService userService;
	
	User user, csalt, cpw;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		input_id = request.getParameter("input_id");
		New_Pw = request.getParameter("input_new_pw");
		New_Pw_same = request.getParameter("input_new_pw_same");
		
		try {
			input_ids = userService.idCheckSelect2(input_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println(input_ids.getId());
		
		// 아이디가 있다면,
		if(input_ids != null)
		{
			try {
				csalt = userService.getSaltSelect(input_id);
				cpw = userService.getPwSelect(input_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("----New_Pw : " + New_Pw + "------ New_Pw_same : " + New_Pw_same);
			
			user = (User) getServletContext().getAttribute("user");
			
			isSame = New_Pw.equals(New_Pw_same); 
			
			try {
				hashedPasswordValid = passwordHashingUtil.hashPassword(New_Pw, csalt.togetSalt());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				// 기존의 비밀번호 같은 지 판단
				isValid = passwordHashingUtil.verifyPassword(hashedPasswordValid, cpw.togetPw());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				// isSame - 사용자가 입력한 두 필드의 비교 / isValid - 사용자가 입력한 비번과 기존의 저장 되어있던 pw와 같은지 여부 판단.
				if(isSame == true && isValid == false) {
					System.out.println("isSame True !!!");
					salt = passwordHashingUtil.generateSalt();
					user.setSalt(salt);
					
					try {
						hashedPassword = passwordHashingUtil.hashPassword(New_Pw, user.getSalt());
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						userService.newPwChange(input_id, user.getSalt(), hashedPassword);
						user.setPw(hashedPassword);
						System.out.println("Hashed Password: " + user.getPw());
				        System.out.println("Salt: " + user.getSalt());
				        System.out.println("비밀번호가 변경 되었습니다. 확인 하시기 바랍니다.");
						response.sendRedirect(request.getContextPath() + "/sLogin");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
					if(isValid == true){
						System.out.println("이전의 사용하던 패스워드 하면 안됩니다.");
					}
					else {
						System.out.println("비밀번호가 맞지 않습니다.");
					}
					
		            
				}
			}
		}
		else {
			// 아이디가 없다면, 
			System.out.println("아이디가 없습니다.");
			response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
		}
		
		
		
		
		
		
		
		
	}
	
}

