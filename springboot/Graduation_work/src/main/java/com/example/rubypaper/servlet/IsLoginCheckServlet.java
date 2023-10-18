package com.example.rubypaper.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/IsLoginCheckServlet")
public class IsLoginCheckServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 유무 확인
		HttpSession session = request.getSession();
		String checkLogin = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		if(checkLogin != null) {
			// 사용자는 로그인 상태
			System.out.println("--------- checkLogin --------- :"+checkLogin);
			response.sendRedirect(request.getContextPath() + "/write");

		} else {
			// No Login 
			System.out.println("로그인 하시고 다시 돌아와");
			response.sendRedirect(request.getContextPath() + "/sLogin");
		}
	}
}
