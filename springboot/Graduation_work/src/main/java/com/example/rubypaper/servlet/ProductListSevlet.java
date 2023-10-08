package com.example.rubypaper.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.service.ServiceList;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductListSevlet")
public class ProductListSevlet extends HttpServlet{
	
	@Autowired
	ServiceList serviceList;

	// 이 서블릿은 sMain에 있는 상품들을 하기 위해서.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ProductListSevlet 실행 되었습니다." );
		
		// 신발 목록 가져오기 
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();
				
		shoesList = serviceList.randSelectShoesId(); // 데이터 저장.
		
		// ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // List<Map<String, Object>>를 JSON으로 변환
        String json = objectMapper.writeValueAsString(shoesList);
        
        // TODO : 이제 json을 html의 js 부분으로 보내면 된다.

        // JSON 출력
        System.out.println(json);

				
	}
}
