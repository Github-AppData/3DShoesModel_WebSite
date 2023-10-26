package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.intellij.lang.annotations.JdkConstants.AdjustableOrientation;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.DetailShoes;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminShoesInfoUpdateServlet")
public class AdminShoesInfoUpdateServlet  extends HttpServlet{
	StringBuilder updateInfo = new StringBuilder();
	Shoes shoes = new Shoes();
	
	@Autowired
	TotalService totalService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        BufferedReader reader = request.getReader();
        
        String line;
        while ((line = reader.readLine()) != null) {
        	updateInfo.append(line);
        }
        String str = updateInfo.toString();
        System.out.println(str);
        
        String [] parts = str.split(",");
        for(int i = 0; i < parts.length; i++)
        {
        	System.out.println(parts[i]);
        }
        int shoes_price = 0;
        shoes_price = Integer.parseInt(parts[0]); // 원래 가격
        
        int sales = 0;
        sales = Integer.parseInt(parts[1]) ; // 할인 율 
        
        String shoes_name = null;
        shoes_name = parts[2]; // 신발 이름
        
        int final_price = 0;
        final_price = Integer.parseInt(parts[3]) ; // 최종 가격 
        
        shoes.setFinal_price(final_price);
        shoes.setSales(sales);
        shoes.setShoes_Name(shoes_name);
        shoes.setShoes_Price(shoes_price);
        
        try {
			totalService.adminPageUpdateShoesInfo(shoes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.sendRedirect(request.getContextPath() + "/adminOrders");
	}
}
