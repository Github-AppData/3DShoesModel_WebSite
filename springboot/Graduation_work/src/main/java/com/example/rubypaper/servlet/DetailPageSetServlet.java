	package com.example.rubypaper.servlet;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DetailPageSetServlet")
public class DetailPageSetServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니에 들어갈 신발 정보 
		HttpSession session2 = request.getSession();
		String jsonData_set = (String) session2.getAttribute("jsonData"); 
		
		System.out.println("jsonData_set : " + jsonData_set.toString());

		JSONParser p = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject)p.parse(jsonData_set);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(obj);
		
		
		String DetailPageInfo = jsonArray.toJSONString();
		
		HttpSession session = request.getSession();
		session.setAttribute("DetailPageInfo", DetailPageInfo);
		
		System.out.println("DetailPageInfo :" + DetailPageInfo);
		
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(DetailPageInfo);
	}

}
