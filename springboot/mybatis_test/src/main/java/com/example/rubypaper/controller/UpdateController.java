package com.example.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rubypaper.service.TotalService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateController {
	
	@Autowired
	TotalService totalList;

	@RequestMapping("/sCart")
	public String sCart(Model model,HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		int numberOfCart = totalList.numberOfCart();
		
		model.addAttribute("numberOfCart", numberOfCart);
		return "test/sCart";
	}
}
