	package com.example.rubypaper.servlet;
	
	import java.io.IOException;
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	
	import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.crypt.PasswordHashingUtil;
import com.example.rubypaper.dto.User;
	
	
	
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	
	@WebServlet("/ReviseInfoServlet")
	public class ReviseInfoServlet extends HttpServlet {
		PasswordHashingUtil passwordHashingUtil = new PasswordHashingUtil();
		String input_pw;
		String input_encryptPassword;
		User user;
		boolean isPasswordValid;
	
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
				input_pw = request.getParameter("input_pw");
				user = (User) getServletContext().getAttribute("user");
				
				try {
					input_encryptPassword = passwordHashingUtil.hashPassword(input_pw, user.getSalt());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("------input_encryptPassword : " + input_encryptPassword);
				System.out.println("-------user.getPw() : "+ user.getPw());
				
				try {
					isPasswordValid = passwordHashingUtil.verifyPassword(input_encryptPassword, user.getPw());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (isPasswordValid) {
					response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
					
					System.out.println("비밀번호가 맞습니다.");
		            
		        } else {
		        	System.out.println("비밀번호가 맞지 않습니다.");
		        	
		            response.sendRedirect(request.getContextPath() + "/pwUpdate");
		        }

		}
	
	    
	    
	}
