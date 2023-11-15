package com.example.rubypaper.servlet;

import java.io.BufferedReader;
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
import jakarta.servlet.http.HttpSession;

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
	User real = new User();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// user_id 구하는 것.
		HttpSession session;
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		System.out.println("userID : "+ userID);
		
		// pwUpdateLast에서 전달 받은 것을 서블릿에서 쓸 수 있도록,,,
		BufferedReader reader = request.getReader();
		StringBuilder pwInfo = new StringBuilder();
	        
	    String line;
	    while ((line = reader.readLine()) != null) {
	    	pwInfo.append(line);
	    }
	    
	    String str = pwInfo.toString();
        String [] parts = str.split(",");
        String pw = parts[0];
        String pw_same = parts[1];
        
        
        
		// 아이디가 있다면,
		if(userID != null)
		{
			isSame = pw.equals(pw_same); 
			
			// 입력된 두 필드의 문자열이 같은지 판단한다.
			if(isSame == true) 
			{
				
				try {
					// id를 통해 기존의 해쉬 값을 가져 옴으로써, 최종적으로 비밀번호가 같은지 여부를 판단.
					checkSalt = userService.getSaltSelect(userID);
					
					// 입력된 패스워드 암호화 
					hashedPasswordValid = passwordHashingUtil.hashPassword(pw, checkSalt.togetSalt());
					
					// 기존의 비밀번호 가지고 오는 코드 
					cpw = userService.getPwSelect(userID);	
					
					// 기존의 비밀번호와 새로운 비밀번호가 같은 지 판단.
					isValid = passwordHashingUtil.verifyPassword(hashedPasswordValid, cpw.togetPw());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// isSame - 사용자가 입력한 두 필드의 비교 / isValid - 사용자가 입력한 비번과 기존의 저장 되어있던 pw와 같은지 여부 판단.
				// 기존의 사용하던 비밀번호가 입력한 패스워드하고 같지 않다면, 
				if(isValid == false) 
				{
					salt = passwordHashingUtil.generateSalt();
					test.setSalt(salt);
					
					try {
						// 여기서는 찐 리얼로 암호화 - 랜덤 해쉬 값 생성.
						hashedPassword = passwordHashingUtil.hashPassword(pw, test.getSalt());
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						// 새로운 패스워드 저장 
						test.setPw(hashedPassword);
						
						System.out.println("hashedPassword : "+ hashedPassword);
						
						// 비밀번호 업데이트 
						System.out.printf("userid : ", userID);
						real.setPw(hashedPassword);
						real.setUser_id(userID);
						real.setSalt(test.getSalt());
						
						userService.newPwChange(real);
						
						// 결과 출력 
						System.out.println("Hashed Password: " + test.getPw());
				        System.out.println("Salt: " + test.getSalt());
				        System.out.println("비밀번호가 변경 되었습니다. 확인 하시기 바랍니다.");
				        response.setStatus(HttpServletResponse.SC_OK); 
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					// 이전에 사용하던 비밀번호와 같을 때의 상태코드 
					System.out.println("이전의 사용하던 패스워드 하면 안됩니다.");
					response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403
				}
				
			// 입력된 두 필드 검사 
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
				System.out.println("입력된 두 필드가 같지 않습니다.");
			}
			
		} else {
			// 아이디가 없을 떄.
			System.out.println("로그인하고 다시 돌아와");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
		}
		
	}
	
}

