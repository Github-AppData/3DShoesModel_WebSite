package com.example.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.BoardService;
import com.example.rubypaper.service.BoardServiceList;
import com.example.rubypaper.service.SearchService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleController {
	
	Object data;
	
	@Autowired
	BoardServiceList boardServiceList;
	
	@Autowired
	SearchService shoesService;
	

	@RequestMapping("/main")
	public String main(Model model, User user)
	{
		model.addAttribute("user", user);
		return "test/main";
	}
	
	@RequestMapping("/noticdBoard")
	public String noticdBoard(Model model)
	{
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		
		//사용자 총 수 
		int result = 0;
				
		try {
			boardList = boardServiceList.getBoardList();
			result = boardServiceList.getBoardValue();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		model.addAttribute("list", boardList);
		
		return "test/noticdBoard";
	}
	
	@RequestMapping("/write")
	public String write()
	{
		return "test/write";
	}
	
	@RequestMapping("/ptest")
	public String ptest(Model model) {
		return "test/ptest";
	}
	
	@GetMapping("/sMain")
	public String sMain(Model model)
	{
		System.out.println("sMain");
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
