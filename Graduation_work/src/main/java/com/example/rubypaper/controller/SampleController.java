package com.example.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/test")
	public String test(Model model)
	{
		return "test/sc1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model)
	{
		return "test/ptest";
	}
	
	@GetMapping("/test3")
	public String test3(Model model)
	{
		return "test/buytest";
	}
}
