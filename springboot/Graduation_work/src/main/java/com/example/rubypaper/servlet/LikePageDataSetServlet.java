package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.rubypaper.service.TotalService;
import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.dto.Like_tb;

@WebServlet("/LikePageDataSetServlet")
public class LikePageDataSetServlet extends HttpServlet{
	
	@Autowired
	TotalService totalService;
	
	Shoes shoes = new Shoes();
	Shoes shoes2 = new Shoes();
	Like_tb like_tb = new Like_tb();
	
	HttpSession session;
	
	
			
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LikePageDataSetServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
        BufferedReader reader = request.getReader();
        StringBuilder AddInfo = new StringBuilder();
        
        
        String line;
        while ((line = reader.readLine()) != null) {
        	AddInfo.append(line);
        }
        
        String str = AddInfo.toString();
        
        String [] parts = str.split(",");
        
        String shoes_id = parts[0];
        String shoes_name = parts[1];
        int final_price = Integer.parseInt(parts[2]);
        int link_id = Integer.parseInt(parts[3]);
        
        try {
        	// 좋아요 테이블 같은 신발이 있는가 ?
			shoes = totalService.shoesIdCheckLike(shoes_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        // 로그인이 되어 있을 때, 
        if(userID != null)
        {
        	// 같은 신발이 없을 때,
        	if(shoes == null)
        	{
        		// 좋아요 DB에 shoes_id가 없을 경우 
    	        try {
    	        	like_tb.setLink_id(link_id);
    	        	like_tb.setShoes_id(shoes_id);
    	        	like_tb.setShoes_name(shoes_name);
    	        	like_tb.setUser_id(userID);
    	        	totalService.isLikeUpdate(shoes_id);
    				totalService.isLikeInfoInsert(like_tb);
    				
    				System.out.println("신발 등록 완료");
    				
    				// 신발 등록 완료.
    				response.setStatus(HttpServletResponse.SC_OK); // 200
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	        
        	 } else {
        		// 좋아요 DB에 shoes_id가 있는 경우
        		// - 좋아요 테이블에서 삭제 하는 거를 해야된다.
            	try {
            		// 신발 테이블에 is_Like 값 업데이트 
            		totalService.isDisableLikeUpdate(shoes_id);
    				totalService.likeDeleteShoesId(shoes_id);
    				
    				// 좋아요 DB에 shoes_id가 있는 경우
    				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
        	
        } 
        else 
        {
        	// 로그인이 되어있지 않는 경우.
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
        }
	}

}
