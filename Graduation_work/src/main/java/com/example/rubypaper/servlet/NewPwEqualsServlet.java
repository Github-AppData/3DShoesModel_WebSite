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
	
	// 이전의 사용하던 비밀번호와 입력한 비밀번호가 같은지 판단하는 isValid
	Boolean isValid = false;
	
	PasswordHashingUtil passwordHashingUtil = new PasswordHashingUtil();
	String hashedPasswordValid, hashedPassword;
	User checkSalt;
	String salt;
	
	@Autowired
	UserService userService;
	
	User cpw;
	User test = new User();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		input_id = request.getParameter("input_id");
		New_Pw = request.getParameter("input_new_pw");
		New_Pw_same = request.getParameter("input_new_pw_same");
		
		System.out.println(input_id);
		
		try {
			checkSalt = userService.getSaltSelect(input_id);
			if(checkSalt == null) {
				System.out.println("아이디가 salt가 존재하지 않습니다.");
				response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		// 아이디가 있다면,
		if(checkSalt != null)
		{
			isSame = New_Pw.equals(New_Pw_same); 
			
			// 입력된 두 필드의 문자열이 같은지 판단한다.
			if(isSame == true) 
			{
				
				try {
					// 입력된 패스워드 암호화 
					hashedPasswordValid = passwordHashingUtil.hashPassword(New_Pw, checkSalt.togetSalt());
					
					// 기존의 비밀번호 가지고 오는 코드 
					cpw = userService.getPwSelect(input_id);
					
					// 기존의 비밀번호 같은 지 판단
					isValid = passwordHashingUtil.verifyPassword(hashedPasswordValid, cpw.togetPw());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// isSame - 사용자가 입력한 두 필드의 비교 / isValid - 사용자가 입력한 비번과 기존의 저장 되어있던 pw와 같은지 여부 판단.
				if(isValid == false) 
				{
					salt = passwordHashingUtil.generateSalt();
					test.setSalt(salt);
					
					try {
						hashedPassword = passwordHashingUtil.hashPassword(New_Pw, test.getSalt());
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						// 새로운 패스워드 저장 
						test.setPw(hashedPassword);
						
						// 비밀번호 업데이트 
						userService.newPwChange(input_id, test.getSalt(), hashedPassword);
						
						// 결과 출력 
						System.out.println("Hashed Password: " + test.getPw());
				        System.out.println("Salt: " + test.getSalt());
				        System.out.println("비밀번호가 변경 되었습니다. 확인 하시기 바랍니다.");
						response.sendRedirect(request.getContextPath() + "/sLogin");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} 
				else {
					response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
					if(isValid == true){
						System.out.println("이전의 사용하던 패스워드 하면 안됩니다.");
					}
					else {
						System.out.println("비밀번호가 맞지 않습니다.");
					}
				}
				
			// 입력된 두 필드 검사 
			} else {
				response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
				System.out.println("입력된 두 필드가 같지 않습니다.");
			}
			
		}	
	}
	
}

