package com.example.rubypaper.servlet;


import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductDetailPageServlet")
public class ProductDetailPageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
		System.out.println("ProductDetailPageServlet !!!");
//		String jsonInfo = request.getParameter("jsonData");
//		
//		
//	    JSONParser jsonparse = new JSONParser();
//	    try {
//			JSONObject jsonObject = (JSONObject) jsonparse.parse(jsonInfo);
//			System.out.println(jsonObject.get("uid"));
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    
		
	}

}
