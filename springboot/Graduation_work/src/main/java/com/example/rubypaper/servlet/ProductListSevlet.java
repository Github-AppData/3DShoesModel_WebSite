package com.example.rubypaper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/ProductListSevlet")
public class ProductListSevlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;

	// 이 서블릿은 sMain에 있는 상품들을 하기 위해서.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ProductListSevlet 실행 되었습니다." );
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		System.out.println(request.getParameter("search"));
		System.out.println(request.getParameter("page"));
		
		int page;
		
		if(request.getParameter("page") == null)
		{
			System.out.println("page가 null");
		}
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1;
		}
		// 신발 목록 가져오기 
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();
		Paging paging = new Paging();
		
		//paging.setPage(Integer.parseInt(request.getParameter("page")));
		System.out.println(paging.getPage());
		paging.setPageSize(6);
		paging.setSearchWord(request.getParameter("search"));
		var startRow = paging.getPageSize() * (page - 1);
		paging.setStartRow(startRow);
		paging.setSearchTag(request.getParameter("tag"));
		try {
			if(request.getParameter("search") != null) {
				shoesList = totalService.searchsMain(paging);
			}else {
				shoesList = totalService.randSelectShoesId(paging);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 데이터 저장.
		
		// ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println("shoesList : "+shoesList);

        // List<Map<String, Object>>를 JSON으로 변환
        String shoes_id = objectMapper.writeValueAsString(shoesList);
        System.out.println("shoes_id : " + shoes_id.toString());
        
        // JSON 출력
        System.out.println(shoes_id);

        // Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(shoes_id);
	}
}
