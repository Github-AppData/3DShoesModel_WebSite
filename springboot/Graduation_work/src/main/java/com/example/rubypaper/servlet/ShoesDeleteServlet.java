package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.TotalService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ShoesDeleteServlet")
public class ShoesDeleteServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShoesDeleteServlet");
		
		BufferedReader reader = request.getReader();
        StringBuilder deleteInfo = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
        	deleteInfo.append(line);
        }
        String shoes_name = deleteInfo.toString();
        System.out.println("shoes_name : "+shoes_name);
        
        try {
			totalService.adminPageDeleteShoesInfo(shoes_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
