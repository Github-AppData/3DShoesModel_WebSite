package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Order_List;
import com.example.rubypaper.service.TotalService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RequestPayServlet")
public class RequestPayServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	Order_List order_List = new Order_List();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestPayServlet");
		
		// 아이디 구하기 
		HttpSession session;
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		

		// 현재 서울 날짜 구하기.
		LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		System.out.println(formatedNow);
		
		// import에서 받아온 값 셋
        BufferedReader reader = request.getReader();
        StringBuilder pay2_Info = new StringBuilder();
        
        String line;
        while ((line = reader.readLine()) != null) {
        	pay2_Info.append(line);
        }
        
        String str = pay2_Info.toString();
        
        String [] parts = str.split(",");
        
        int size = Integer.parseInt(parts[0]);
        String shoes_name = parts[1];
        String shoes_id = parts[2];
        int quantity = Integer.parseInt(parts[3]);
        int price = Integer.parseInt(parts[4]);
        String way = parts[5];
        
        
        // 객체에 정보 셋.
        order_List.setSize(size);
        order_List.setOrder_date(formatedNow);
        order_List.setUser_id(userID);
        order_List.setPrice(price);
        order_List.setQuantity(quantity);
        order_List.setShoes_name(shoes_name);
        order_List.setWay(way);
        order_List.setShoes_id(shoes_id);
        
        try {
			totalService.requestPay2InfoInsert(order_List);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("order_List : "+ order_List);
	}

}
