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

import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.BoardService;
import com.example.rubypaper.service.TotalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SampleController {
	
	Object data;
	
	@Autowired
	TotalService totalList;
	
	@RequestMapping("/mypage")
	public String mypage(Model model, HttpServletRequest request, HttpSession session)
	{
		
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
				
		//사용자 총 수 
		int result = 0;
		
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		System.out.println(userID);
		try {
			boardList = totalList.myPageUserDataSet(userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("boardList"+boardList.toString());
						
		model.addAttribute("list", boardList);
		model.addAttribute("userID", userID); // userID를 전한다.
		
		return "test/mypage";
	}

	@RequestMapping("/main")
	public String main(Model model, HttpServletRequest request, HttpSession session)
	{
		
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		return "test/main";
	}
	
	@RequestMapping("/sDetails")
	public String sDetails(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		
		
		return "test/sDetails";
	}	
	
	@RequestMapping("/noticdBoard")
	public String noticdBoard(Model model, HttpServletRequest request, HttpSession session)
	{
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		
		//사용자 총 수 
		int result = 0;
				
		try {
			boardList = totalList.boardFindList();
			totalList.FindListIsDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		model.addAttribute("list", boardList);
		
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		return "test/noticdBoard";
	}
	
	@GetMapping("/wDetails")
	public String wDetails(Model model, HttpServletRequest request, HttpSession session, HttpSession session2)
	{
		System.out.println("wDetails");
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
								
		model.addAttribute("userID", userID); // userID를 전한다.
		
		session2 = request.getSession();
		Object idx = (Object) session2.getAttribute("idx");
		
		int idx_real = Integer.parseInt(idx.toString());
		
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardIdxDataList = new ArrayList<Map<String, Object>>();
		
		boardIdxDataList = totalList.boardIdxData(idx_real);
		
		System.out.println(boardIdxDataList.toString());
		model.addAttribute("boardIdxDataList", boardIdxDataList);
		
		return "test/wDetails";
	}
	
	
	
	@RequestMapping("/write")
	public String write(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		return "test/write";
	}
	
	
	@RequestMapping("/ptest")
	public String ptest(Model model) {
		return "test/ptest";
	}
	
	@GetMapping("/sMain")
	public String sMain(Model model,HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
								
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		
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
	
	
	
	
	@GetMapping("/sBlog")
	public String sBlog(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		return "test/sBlog";
	}	
	
	@GetMapping("/sContact")
	public String sContact(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		return "test/sContact";
	}	
	
	
	
	
	@RequestMapping("/like")
	public String like(Model model,HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		
		return "test/like";
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