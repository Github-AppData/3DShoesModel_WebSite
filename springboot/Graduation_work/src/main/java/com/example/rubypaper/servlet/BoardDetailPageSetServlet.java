package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardDetailPageSetServlet")
public class BoardDetailPageSetServlet extends HttpServlet{
	
	
	@Autowired
	BoardService boardService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("BoardDetailPageSetServlet");
	    
	    // linkId를 쿼리 문자열에서 추출
	    String linkId = request.getParameter("linkId");
	    
	    // linkId가 null 또는 빈 문자열인 경우 예외 처리
	    if (linkId == null || linkId.isEmpty()) {
	        // 예외 처리 로직
	    } else {
	        // linkId를 정수로 변환
	        int idx_real = Integer.parseInt(linkId);
	        
	        // 여기에서 필요한 로직을 수행
	        HttpSession session = request.getSession();
	        session.setAttribute("idx", idx_real);
	    }
	    
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("asd");
	}


}
