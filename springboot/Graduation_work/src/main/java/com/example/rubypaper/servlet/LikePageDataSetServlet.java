package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.rubypaper.service.TotalService;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.dto.Like_tb;

@WebServlet("/LikePageDataSetServlet")
public class LikePageDataSetServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	Shoes shoes = new Shoes();
	Shoes shoes2 = new Shoes();
	Like_tb like_tb = new Like_tb();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LikePageDataSetServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        BufferedReader reader = request.getReader();
        StringBuilder AddInfo = new StringBuilder();
        
        String line;
        while ((line = reader.readLine()) != null) {
        	AddInfo.append(line);
        }
        System.out.println("AddInfo : "+AddInfo.toString());
        
        String str = AddInfo.toString();
        
        String [] parts = str.split(",");
        
        String shoes_id = parts[0];
        String shoes_name = parts[1];
        int final_price = Integer.parseInt(parts[2]);
        int link_id = Integer.parseInt(parts[3]);
        

        
        try {
			shoes = totalService.shoesIdCheckLike(shoes_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(shoes == null)
        {
	        try {
	        	like_tb.setLink_id(link_id);
	        	like_tb.setShoes_id(shoes_id);
	        	
	        	totalService.isLikeUpdate(shoes_id);
				totalService.isLikeInfoInsert(like_tb);
				
				response.setStatus(HttpServletResponse.SC_OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        else 
        {
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	System.out.println("이미 상품이 있습니다.");
        		
        }
        
     // Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("sasdda");
        
        
	}

}
