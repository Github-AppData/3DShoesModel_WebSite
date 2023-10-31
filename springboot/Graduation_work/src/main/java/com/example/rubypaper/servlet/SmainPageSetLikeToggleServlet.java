package com.example.rubypaper.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SmainPageSetLikeToggleServlet")
public class SmainPageSetLikeToggleServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	List<Map<String, Object>> link_ids = new ArrayList<Map<String, Object>>();
	// linkId를 담을 int 배열 생성
	
	int[] linkIdArray;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
            link_ids = totalService.linkIdSelectLike();
            linkIdArray = new int[link_ids.size()];
            
         // link_ids 리스트에서 link_id 값을 추출하여 int 배열에 담기
            for (int i = 0; i < link_ids.size(); i++) {
                Map<String, Object> map = link_ids.get(i);
                if (map.containsKey("link_id")) {
                    linkIdArray[i] = (int) map.get("link_id");
                    System.out.println("linkIdArray[i] : "+linkIdArray[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리
        }
		
		 // ObjectMapper를 사용하여 int 배열을 JSON 형식의 문자열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(linkIdArray);
        
        response.setStatus(HttpServletResponse.SC_OK);
		
        // Content Type 및 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 응답으로 JSON 데이터 보내기
        response.getWriter().write(json);

		
	}

}
