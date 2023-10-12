package com.example.rubypaper.servlet;

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
		
		// 장바구니에 들어갈 신발 정보 
		HttpSession session2 = request.getSession();
		String jsonData_cart = (String) session2.getAttribute("jsonArrayString"); // 로그인 아이디가 checkLogin에 들어가 있다.
		

		// JSON 문자열을 Java 객체로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		DetailShoes[] yourObjects = objectMapper.readValue(jsonData_cart, DetailShoes[].class);	
		
		int shoes_price = 0;
		String shoes_name = null;
		String shoes_id = null;
		
		if (yourObjects.length > 0) {
		    DetailShoes shoes = yourObjects[0];
		    shoes_name = shoes.getShoes_name();
		    shoes_price = shoes.getShoes_price();
		    shoes_id = shoes.getUid();
		}
		
		if(checkLogin != null) {
			// 사용자는 로그인 상태
			System.out.println("--------- checkLogin --------- :"+checkLogin);
			
			// 값 추출 - 사이즈, 수량, 3D Model Id, 신발 이름
		    String selectedSize = request.getParameter("selectedSize");
		    String quantityInput = request.getParameter("quantityInput");
		    
		    int quantity = Integer.parseInt(quantityInput);
		    int size = Integer.parseInt(selectedSize);
		    
		    
		    System.out.println("--------- size --------- :"+size);
		    System.out.println("--------- quantity --------- :"+quantity);
		    
		 
		    
		    // 여기다가 3D Model의 id만 추가 하고, 장바구니에서는 해당 아이디 값만, 적용시켜 주는 데에 넣어주면 딴.
		    
		    try {
		    	
		    	// 신발 아이디가 검색된 게 없다면, 
				if(cartService.cartCheckShoesId(shoes_id) == null)
				{
					response.setStatus(HttpServletResponse.SC_OK);
					cart.setQuantity(quantity);
				    cart.setSize(size);
				    cart.setShoes_name(shoes_name);
				    cart.setShoes_id(shoes_id);
				    cart.setShoes_price(shoes_price);
				    cart.setUser_id(checkLogin);
					cartService.cartInsert(cart);
					
					HttpSession session3 = request.getSession();
					session3.setAttribute("cart", cart);
					
					System.out.println("추가 됨");
					
					response.sendRedirect(request.getContextPath() + "/sDetails");

				} else {
					// 신발이 고른 것이 이미 장바구니에 있다면, 
					System.out.println("이미 장바구니에 있습니다.");
					response.setStatus(HttpServletResponse.SC_GONE);
					response.sendRedirect(request.getContextPath() + "/sDetails");
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
