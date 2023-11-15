package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Order_List;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonElement;
import com.nimbusds.jose.shaded.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kotlinx.serialization.json.internal.JsonException;
import net.minidev.json.JSONArray;


@WebServlet("/PayCartServlet")
public class PayCartServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	Order_List order_List = new Order_List();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("PayCartServlet");
		
		System.out.println("PayCartServlet");
		
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
        
	        StringBuilder pay2_Info = new StringBuilder();
	        String line;
	        
	        BufferedReader reader = request.getReader();
	        while ((line = reader.readLine()) != null) {
	            pay2_Info.append(line);
	        }
        	
        	String jsonData = pay2_Info.toString();
        		
        	ObjectMapper objectMapper = new ObjectMapper();
        	JsonNode rootNode = objectMapper.readTree(jsonData);
        	

        	// JSON 데이터의 키 개수 가져오기
        	int numberOfKeys = rootNode.size();
        	
        	for (int i = 0; i < numberOfKeys; i++) {
        	    String shoesKey = "shoes" + i;
        	    JsonNode shoesNode = rootNode.get(shoesKey);

        	    if (shoesNode != null) {
        	        String shoeName = shoesNode.path("shoes_name").asText();
        	        String way = shoesNode.path("way").asText();
        	        int shoePrice = shoesNode.path("final_price").asInt();
        	        int shoesSize = shoesNode.path("size").asInt();
        	        int quantity = shoesNode.path("shoes_quantity").asInt();

        	        System.out.println("Shoe Name: " + shoeName);
        	        System.out.println("Shoe Price: " + shoePrice);
        	        System.out.println("shoes_quantity: " + quantity);
        	        System.out.println("shoesSize: " + shoesSize);
        	        
        	        order_List.setSize(shoesSize);
        	        order_List.setOrder_date(formatedNow);
        	        order_List.setUser_id(userID);
        	        order_List.setPrice(shoePrice);
        	        order_List.setQuantity(quantity);
        	        order_List.setShoes_name(shoeName);
        	        order_List.setWay(way);
        	        
        	        try {
						totalService.requestPay2InfoInsert(order_List);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	    } 
        	}
	}
}
