package com.example.rubypaper.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import jakarta.servlet.http.HttpSession;
>>>>>>> 1160fbc76c5d464cdd84a8a0f920ce838f99f87c

@WebServlet("/LikePageServlet")
public class LikePageServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD
=======
		// user_id 구하는 것.
		HttpSession session;
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		
>>>>>>> 1160fbc76c5d464cdd84a8a0f920ce838f99f87c
		int page;
		List<Map<String, Object>> likeList = new ArrayList<Map<String, Object>>();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1;
		}
		
		Paging paging = new Paging();
		System.out.println(paging.getPage());
		paging.setPageSize(6);
		var startRow = paging.getPageSize() * (page - 1);
		paging.setStartRow(startRow);
		
<<<<<<< HEAD
		try {
			likeList = totalService.isLikeSelect(paging);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // List<Map<String, Object>>를 JSON으로 변환
        String likeList2 = objectMapper.writeValueAsString(likeList);
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(likeList2);
=======
		// 아이디가 있다면,
		if(userID != null)
		{
			try {
				likeList = totalService.isLikeSelect(paging);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// ObjectMapper 생성
	        ObjectMapper objectMapper = new ObjectMapper();
	
	        // List<Map<String, Object>>를 JSON으로 변환
	        String likeList2 = objectMapper.writeValueAsString(likeList);
			// Content-Type 설정 (JSON으로 응답)
	        request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write(likeList2);
		} else {
			System.out.println("로그인 하고 오세요.");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
>>>>>>> 1160fbc76c5d464cdd84a8a0f920ce838f99f87c
	}

}
