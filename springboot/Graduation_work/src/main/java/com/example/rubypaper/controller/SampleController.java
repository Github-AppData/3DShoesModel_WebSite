package com.example.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rubypaper.dto.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleController {
	
	Object data;
	

	@RequestMapping("/main")
	public String main(Model model)
	{
		
		return "test/main";
	}
	
	@RequestMapping("/ptest")
	public String ptest(Model model) {
		return "test/ptest";
	}
	
	@GetMapping("/sMain")
	public String sMain(Model model)
	{
		return "test/sMain";
	}
	
	@RequestMapping("/findPw")
	public String findPw(Model model)
	{
		return "test/findPw";
	}
	
	@RequestMapping("/PwUpdate")
	public String pwUpdate(Model model, User user) {
		model.addAttribute("user", user);
		return "test/pwUpdate";
	}
	
	@RequestMapping("/pwUpdateLast")
	public String pwUpdateLast(Model model, User user) {
		return "test/pwUpdateLast";
	}
	
	
	@GetMapping("/sDetails")
	public String test3(Model model)
	{
		return "test/sDetails";
	}	
	
	@GetMapping("/sBlog")
	public String test4(Model model)
	{
		return "test/sBlog";
	}	
	
	@GetMapping("/sContact")
	public String test5(Model model)
	{
		return "test/sContact";
	}	
	
	@GetMapping("/sCart")
	public String test6(Model model)
	{
		return "test/sCart";
	}
	
	@GetMapping("/sLogin")
	public String Login()
	{
		return "test/login";
	}
	
	@PostMapping("/sBuying")
	public String test8(Model model)
	{
		return "test/sBuying";
	}
	@GetMapping("/SignUp")
	public String SignUp(Model model)
	{
		return "test/SignUp";
	}	
}
