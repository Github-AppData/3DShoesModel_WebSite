package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.CartService;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	
	@Autowired
	TotalService totalService;
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CartUpdateServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        BufferedReader reader = request.getReader();
        StringBuilder deleteInfo = new StringBuilder();
        
        String line = null;
        while ((line = reader.readLine()) != null) {
        	
        	deleteInfo.append(line);
        }
        System.out.println("deleteInfo : "+deleteInfo);
        
        String str = deleteInfo.toString();
        
        String [] parts = null;
        
        parts = str.split(",");
        
        String shoes_id = null;
        shoes_id = parts[0];
        
        
        System.out.println("shoes_id : "+shoes_id);
        
        try {
			totalService.cartUpdateIsDelete(shoes_id);
			
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
