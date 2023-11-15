	package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.TotalService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminPageShoesInsertServlet")
public class AdminPageShoesInsertServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	Shoes shoes = new Shoes();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
        StringBuilder updateInfo = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
        	updateInfo.append(line);
        }
        String str = updateInfo.toString();
        System.out.println("str"+str);
        
        String [] parts = str.split(",");
        
        
        String shoes_id = parts[0];
        String shoes_name = parts[1];
        int shoes_price = Integer.parseInt(parts[2]);
        
        shoes.setShoes_id(shoes_id);
        shoes.setShoes_price(shoes_price);
        shoes.setShoes_name(shoes_name);
        
        int final_price = shoes_price;
        shoes.setFinal_price(final_price);
        
        try {
			totalService.adminPageShoesInsert(shoes);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

}
