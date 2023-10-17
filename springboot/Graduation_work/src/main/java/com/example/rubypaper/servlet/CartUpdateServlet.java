package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.CartService;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	
	@Resource
	TotalService totalService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CartUpdateServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        BufferedReader reader = request.getReader();
        StringBuilder delete_uid = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
        	delete_uid.append(line);
        }
        
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        String result = null;
        
        try {
            String jsonString = objectMapper.writeValueAsString(delete_uid);
            System.out.println(jsonString);
            
         // JSON 문자열을 일반 문자열로 변환
            result = objectMapper.readValue(jsonString, String.class);

            System.out.println("일반 문자열: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        String valid = "12bed79f58014290baa9baca711f66b7";
        
        String s = null;
        try {
			s = totalService.cartFindShoesId(valid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("s : "+s);
        
//        
//        // 12bed79f58014290baa9baca711f66b7
//        byte[] utf8Bytes2 = valid.getBytes("UTF-8");
//        String utf8String2 = new String (utf8Bytes2, "UTF-8");
//        
//        System.out.println("UTF-8로 인코딩된 result: " + utf8String);
//        System.out.println("UTF-8로 인코딩된 12bed79f58014290baa9baca711f66b7: " + utf8String2); 
//        
//        if(result.equals(utf8String2))
//        {
//        	System.out.println("당신은 무엇이든 해내는 남자");
//        }else {
//        	System.out.println("No !!!");
//        }
        
        
        /*try {
        	totalService.cartUpdateIsDelete(utf8String);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println("delete_uid.toString() : "+  delete_uid.toString());
        
        
        // JSON 데이터를 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("delete_uidㅁㄴㅇㅁ", delete_uid.toString());*/
	}

}
