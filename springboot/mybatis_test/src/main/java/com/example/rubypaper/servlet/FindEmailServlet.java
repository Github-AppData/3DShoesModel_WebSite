package com.example.rubypaper.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FindEmailServlet")
public class FindEmailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : 이메일 인증 구현하기 
		
		// 이메일 인증 성공하면, 
		response.sendRedirect(request.getContextPath() + "/pwUpdateLast");
	}
	
}
