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

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	
	User isIds;
	
	String check_id, check_pw;
	
	@Autowired
	UserService userService;
	
	Boolean isPwValid = false;
	String hassedPassword;
	

	boolean isValidPw = false;
	User salt, stored_pw, user;
	
	PasswordHashingUtil passwordHashingUtil = new PasswordHashingUtil();

	// 이 서블릿은 로그인시 조건을 체크하는 서블릿 입니다.
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		check_id = request.getParameter("login_id");
		check_pw = request.getParameter("login_pw");
		
		try {
			salt = userService.getSaltSelect(check_id);
			stored_pw = userService.getPwSelect(check_id);
			if (salt == null) {
		        System.out.println("아이디에 대한 salt가 존재하지 않습니다.");
		        response.sendRedirect(request.getContextPath() + "/sLogin");
		    } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(salt != null)
		{
			// 아이디와 salt 값이 있을 경우. 
			try {
				hassedPassword = passwordHashingUtil.hashPassword(check_pw, salt.togetSalt());
				isPwValid = passwordHashingUtil.verifyPassword(hassedPassword, stored_pw.togetPw());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isPwValid == true) {
				System.out.println("----- 로그인 성공 -----");
				response.sendRedirect(request.getContextPath() + "/main");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				response.sendRedirect(request.getContextPath() + "/sLogin");
			}
		}

		
	}
}
