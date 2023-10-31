package com.example.rubypaper.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.Cart;
import com.example.rubypaper.dto.DetailShoes;
import com.example.rubypaper.service.CartService;
import com.example.rubypaper.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartAddObjectServlet")
public class CartAddObjectServlet extends HttpServlet{
	
	Cart cart = new Cart();
	
	@Autowired
	CartService cartService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 유무 확인
		HttpSession session = request.getSession();
		String checkLogin = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		
		System.out.println("CartAddObjectServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        BufferedReader reader = request.getReader();
        StringBuilder CartSetInfo = new StringBuilder();
        
        String line;
        while ((line = reader.readLine()) != null) {
        	CartSetInfo.append(line);
        }
        System.out.println("CartSetInfo2 : "+CartSetInfo.toString());
        
        String str = CartSetInfo.toString();
        
        String [] parts = str.split(",");
        
        String shoes_id = parts[0];
        String shoes_name = parts[1];
        int final_price = Integer.parseInt(parts[2]);
        int quantity = Integer.parseInt(parts[3]);
        int size = Integer.parseInt(parts[4]);
        
		
		
		if(checkLogin != null) {
			// 사용자는 로그인 상태
			System.out.println("--------- checkLogin --------- :"+checkLogin);
			
		    
		    System.out.println("--------- size --------- :"+size);
		    System.out.println("--------- quantity --------- :"+quantity);
		 
		    
		    try {
		    	// 신발 아이디가 검색된 게 없다면, 
				if(cartService.cartCheckShoesId(shoes_id) == null)
				{
					
					cart.setQuantity(quantity);
				    cart.setSize(size);
				    cart.setShoes_name(shoes_name);
				    cart.setShoes_id(shoes_id);
				    cart.setShoes_price(final_price);
				    cart.setUser_id(checkLogin);
					cartService.cartInsert(cart);
					
					HttpSession session3 = request.getSession();
					session3.setAttribute("cart", cart);
					
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					// 신발이 고른 것이 이미 장바구니에 있다면, 
					response.setStatus(HttpServletResponse.SC_GONE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} else {
			// No Login 
			System.out.println("로그인 하시고 다시 돌아와");
			response.sendRedirect(request.getContextPath() + "/sLogin");
		}
		// Content-Type 설정 (JSON으로 응답)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("ㅁㄴㅇㅁㄴ");
		
	}
}
