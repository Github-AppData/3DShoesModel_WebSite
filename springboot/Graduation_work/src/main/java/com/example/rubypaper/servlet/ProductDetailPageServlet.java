package com.example.rubypaper.servlet;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProductDetailPageServlet")
public class ProductDetailPageServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트로부터의 JSON 데이터 수신
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuffer.append(line);
        }
        
        System.out.println("jsonBuffer : " + jsonBuffer);
        
        
        // JSON 데이터를 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("jsonData", jsonBuffer.toString());
	}

}
