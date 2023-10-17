package com.example.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;import rg.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControlle
import com.example.rubypaper.dto.Paging;import o m.example.rubypaper.dto.User;
import com.example.rubypaper.service.TotalService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SampleController {
	
	Object data;
	

	TotalService

	@GetMapping("/mypage")
	public String mypage(Model

		//사용자 목록 가져오기 
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>(); 			
		// 사용자 총 수 
		int result = 0;

		//  user_i 구하는 것.
		session = reque

		System.out.println(userID);
		try {
			boardList = totalSerivce.myPageUserDataSet(userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("boardList"+boardList.toString());
						
		model.addAttribute("list", boardList);
		model.addAttribute("userID", u s erID); // userID를 전한다.

		return "test/mypage";
	}

		GetMapping("/main")
	public String main(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession(); 	String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);

		return "test/main";
	}

		GetMapping("/sDetails")
	p

		// user_id 구하는 것.
		session = request.getSession(); 	String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		

		return "test/sDetails";

		GetMapping("/noticdBoard")
	p

			//사용자목록 가 	List<Map<String, Object>> boar

		
		//페이징

		Paging paging = new Paging();
		
		paging.setPage(page);
		var startRow = 10 * (page - 1);
		paging.setStartRow(startRow);
		
		//사용자 총 수 
		int result = 0;
				
		try {
			boardList = serviceList.getBoardList(paging);
			result = serviceList.getBoardValue();
			paging.setTotalArticle(result);
			serviceList.FindListIsDelete();
			boardList = totalSerivce.boardFindList();
			totalSerivce.FindListIsDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		model.addAttribute("list", boardList);
		model.addAttribute("paging", paging);
		
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
		

		Object idx = (Object) session2.getAttribute("idx");
		 	int idx_real = Integer.parseInt(idx.toString());
		
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardIdxDataList = new ArrayList<Map<String, Object>>();
		

		

			boardIdxDataList = totalSerivce.boardIdxData(idx_real);
		} catch (Exception e) {

			e.printStackTrace();

		 
		System.out.println(boardIdxDataList.toString());

		  

		
	
	@GetMapping("/sCart")
	public String sCart(Model model,HttpServletRequest request, HttpSession session)
	{
		/

		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						

		System.out.println("userID : " + userID);
		

		
		model.addAttribute("numberOfCar t", numberOfCart); 	return "test/sCart";
	}
	
	

		GetMapping("/write")
	public String write(Model model, HttpServl

		// user_id 구하는 것.

		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		

	
	@GetMapping("/ptest") public String ptest(Model model) {
		return "test/ptest";
	}
	

		ublic String sMain(Model model,HttpServletRequest request, HttpSession session)
	{
		

								
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		

	}
	  @GetMapping("/findPw")
	public String findPw(Model model)
	{
		return "test/findPw";

		
	@GetMapping("/PwUpdate")

		model.addAttribute("user", user);
		

	
	@GetMapping("/pwUpdateLast") public String pwUpdateLast(Model model, User user) {
		return "test/pwUpdateLast";
	}

	
	
	
	@GetMapping("/sBlog")
	p

		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		

	@GetMapping("/sContact")
	public String sContact(Model model, HttpServletRequest request, HttpSession sessi {
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.

		model.addAttribute("userID", userID); // userID를 전한다.
		return "test/sContact";
	}

	
	 
	@GetMapping("/like")
	public String like(Model model,HttpServletRequest request, HttpSession session)
	{

		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
		

		return "test/like";
	}  
	@GetMapping("/sLogin")
	public String Login()
	{

		
	

		
		

	@GetMapping("/SignUp")
	public String SignUp( {
		return "test/SignUp";
	}

	 

	 
