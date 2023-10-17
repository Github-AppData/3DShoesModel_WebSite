package com.example.rubypaper.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardCountServlet")
public class boardCountServlet extends HttpServlet{
	@Autowired
	BoardService boardService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int s = 0;
		try {
			s = boardService.boardCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(Integer.toString(s));
	}

}
