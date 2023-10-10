package com.example.rubypaper.servlet;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		String jsonData_set = (String) session2.getAttribute("jsonData"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
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
		
		
		String jsonArrayString = jsonArray.toJSONString();
		
		HttpSession session = request.getSession();
		session.setAttribute("jsonArrayString", jsonArrayString);
		
		System.out.println("jsonArrayString :" + jsonArrayString);
		
		
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(jsonArrayString);
	}

}
