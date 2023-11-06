package com.example.rubypaper.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminSearchUser")
public class AdminSearchUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		String searchWord = URLEncoder.encode(request.getParameter("searchorders"),"UTF-8");
		response.sendRedirect(request.getContextPath() + "/adminDocs?search=" + searchWord);
	}
}
