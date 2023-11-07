package com.example.rubypaper.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rubypaper.dto.MailDTO;
import com.example.rubypaper.service2.MailService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MailController {

	MailService mailService;
	
	@Autowired
    public MailController(MailService mailService) {
		this.mailService = mailService;
	}

    @GetMapping("/mail")
    public String dispMail() {
        return "mail";
    }
    
    

    @PostMapping("/findPw")
    public String execMail(String mail, HttpServletRequest request, HttpServletResponse response)
    {
    	System.out.println("mail : "+ mail);
    	
    	int number = mailService.sendMail(mail);

        String num = null;
        	num = "" + number;
        
        System.out.println("controller num : "+ num);
        
        HttpSession session;
	     // user_id 구하는 것.	
	     session = request.getSession();
	     session.setAttribute("number", num); // 로그인 아이디가 checkLogin에 들어가 있다.
	     
	     try {
			response.sendRedirect("/findPwNumberSetServlet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "test/findPw";
    }
}
