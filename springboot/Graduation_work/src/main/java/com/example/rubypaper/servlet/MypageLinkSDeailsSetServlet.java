package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MypageLinkSDeailsSetServlet")
public class MypageLinkSDeailsSetServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		System.out.println("MypageLinkSDeailsSetServlet");
		
		List<Map<String, Object>> setData = new ArrayList<Map<String, Object>>();
		
		BufferedReader reader = request.getReader();
        StringBuilder order_id_info = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
        	order_id_info.append(line);
        }
        
        System.out.println("order_id_info.toString() : "+order_id_info.toString());
        
        
        int order_id = Integer.parseInt(order_id_info.toString());
        try {
			setData = totalService.myPageToSDetailsSetSelect(order_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("setData : "+ setData);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String setData2 = objectMapper.writeValueAsString(setData);
		
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(setData2);
		
        
	}

}
