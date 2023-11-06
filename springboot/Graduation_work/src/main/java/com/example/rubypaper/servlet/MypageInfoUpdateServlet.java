package com.example.rubypaper.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MypageInfoUpdateServlet")
public class MypageInfoUpdateServlet extends HttpServlet{
	
	@Autowired
	UserService userService;
	
	Date birth_date;
	
	User user = new User();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String detail_adress = request.getParameter("detail_adress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		
		HttpSession session;// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    
	    
	    try {
	    	birth_date = (Date) dateFormat.parse(birthday);
		} catch (ParseException e) {
			// TODO: handle exception
		}
		
		user.setAdress(adress);
		user.setDetail_adress(detail_adress);
		user.setName(name);
		user.setBirthday(birth_date);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUser_id(userID);
		
		try {
			userService.userInfoUpdate(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/mypage");
		
	}
}
