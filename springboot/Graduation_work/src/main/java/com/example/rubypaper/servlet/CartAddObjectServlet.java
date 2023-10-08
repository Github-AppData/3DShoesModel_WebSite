package com.example.rubypaper.servlet;

import java.io.IOException;

import com.example.rubypaper.dto.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartAddObjectServlet")
public class CartAddObjectServlet extends HttpServlet{
	
	Cart cart = new Cart();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 유무 확인
		HttpSession session = request.getSession();
		String checkLogin = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		if(checkLogin != null) {
			// 사용자는 로그인 상태
			System.out.println("--------- checkLogin --------- :"+checkLogin);
			
			// 값 추출 - 사이즈, 수량, 3D Model Id, 신발 이름
		    String selectedSize = request.getParameter("selectedSize");
		    String quantityInput = request.getParameter("quantityInput");
		    
		    int size = Integer.parseInt(selectedSize);
		    int quantity = Integer.parseInt(quantityInput);
		    
		    // 여기다가 3D Model의 id만 추가 하고, 장바구니에서는 해당 아이디 값만, 적용시켜 주는 데에 넣어주면 딴.
		    
		    cart.setQuantity(quantity);
		    cart.setSize(size);
		    
		    
		} else {
			// No Login 
			System.out.println("로그인 하시고 다시 돌아와");
			response.sendRedirect(request.getContextPath() + "/sLogin");
		}
		
		
	}
}
