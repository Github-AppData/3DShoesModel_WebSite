package com.example.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SampleController {

	@GetMapping("/main")
	public String test1(Model model)
	{
		return "test/main";
	}
	
	@GetMapping("/sMain")
	public String test2(Model model)
	{
		return "test/sMain";
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
	public String test7(Model model)
	{
		return "test/sLogin";
	}
	@PostMapping("/sBuying")
	public String test8(Model model)
	{
		return "test/sBuying";
	}	
}
