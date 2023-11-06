package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.CartService;
import com.example.rubypaper.service.TotalService;
import com.example.rubypaper.service.UpdateService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	
	@Autowired
	UpdateService updateService;
//	ServiceList serviceList;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CartUpdateServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 클라이언트로부터의 JSON 데이터 수신
        BufferedReader reader = request.getReader();
        StringBuilder delete_uid = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
        	delete_uid.append(line);
        }
        
        System.out.println("Before delete_uid : " + delete_uid);
        String sa = delete_uid.toString();
        System.out.println("After delete_uids : " + delete_uid);
        
        try {
        	updateService.cartUpdateIsDelete(delete_uid.toString());
//			serviceList.cartUpdateIsDelete(gf);
//        	updateService.cartUpdateIsDelete(gf);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("delete_uid.toString() : "+  delete_uid.toString());
//        
        
//        // JSON 데이터를 세션에 저장
//        HttpSession session = request.getSession();
//        session.setAttribute("delete_uidㅁㄴㅇㅁ", delete_uid.toString());
	}

}
