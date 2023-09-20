package com.hungry.login.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hungry.login.dto.UserDTO;

@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("singUp")
	public String singUp() {
		return "/singUp";
	}
	
	@PostMapping("/main")
	public String main(UserDTO userDTO, Model model) {
		
		model.addAttribute("uId", userDTO.getUId());
		
		return "/main";
	}
}
