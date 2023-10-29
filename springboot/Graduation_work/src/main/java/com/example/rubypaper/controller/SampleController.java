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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rubypaper.dto.Paging;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.service.TotalService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SampleController {
	
	Object data;
	
	@Autowired
	TotalService totalService;
	
	@GetMapping("/mypage")
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
			boardList = totalService.myPageUserDataSet(userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("boardList"+boardList.toString());
						
		model.addAttribute("list", boardList);
		model.addAttribute("userID", userID); // userID를 전한다.
		
		return "test/mypage";
	}

	@GetMapping("/main")
	public String main(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		return "test/main";
	}
	
	@GetMapping("/sDetails")
	public String sDetails(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		
		
		return "test/sDetails";
	}	
	
	@GetMapping("/noticdBoard")
	public String noticdBoard(@RequestParam(value="page", defaultValue = "1") int page ,Model model, HttpServletRequest request, HttpSession session)
	{
		//사용자 목록 가져오기 
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		
		//페이징 객체 생성
		Paging paging = new Paging();
		
		paging.setPage(page);
		var startRow = 10 * (page - 1);
		paging.setStartRow(startRow);
		
		//사용자 총 수 
		int result = 0;
				
		try {
				boardList = totalService.boardFindList(paging);
				totalService.FindListIsDelete();
				var boardCount = totalService.boardCount();
				
				System.out.println("boardCount : "+boardCount);
				paging.setTotalArticle(boardCount);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		model.addAttribute("list", boardList);
		model.addAttribute("paging", paging);
		
		System.out.println("boardList : "+boardList);
		
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		return "test/noticdBoard";
	}
	
	@GetMapping("/hearts")
	public String hearts() {
		return "test/hearts";
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
		
		System.out.println("idx_real : "+idx_real);
		
		try {
			boardIdxDataList = totalService.boardIdxData(idx_real);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(boardIdxDataList.toString());
		model.addAttribute("boardIdxDataList", boardIdxDataList);
		
		return "test/wDetails";
	}
	
	@GetMapping("/sCart")
	public String sCart(Model model,HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
						
		model.addAttribute("userID", userID); // userID를 전한다.
		System.out.println("userID : " + userID);
		
		try {
			totalService.cartDeleteShoesId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int numberOfCart = totalService.numberOfCart();
		
		model.addAttribute("numberOfCart", numberOfCart);
		return "test/sCart";
	}
	
	
	
	@GetMapping("/write")
	public String write(Model model, HttpServletRequest request, HttpSession session)
	{
		// user_id 구하는 것.
		session = request.getSession();
		String userID = (String) session.getAttribute("userID"); // 로그인 아이디가 checkLogin에 들어가 있다.
				
		model.addAttribute("userID", userID); // userID를 전한다.
		return "test/write";
	}
	
	
	@GetMapping("/ptest")
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
	
	@GetMapping("/findPw")
	public String findPw(Model model)
	{
		return "test/findPw";
	}
	
	@GetMapping("/PwUpdate")
	public String pwUpdate(Model model, User user) {
		model.addAttribute("user", user);
		return "test/pwUpdate";
	}
	
	@GetMapping("/pwUpdateLast")
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
	
	
	
	
	@GetMapping("/like")
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
	
	@GetMapping("/adminMain")
	public String adminMain(Model model)
	{
		//사용자 목록 가져오기 
		List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
		
		try {
			userList = totalService.adminPageSelectUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("userList", userList);
		return "test/adminMain";
	}
	
	@GetMapping("/admin404")
	public String admin404()
	{
		return "test/admin404";
	}
	
	@GetMapping("/adminAccount")
	public String adminAccount(Model model)
	{
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		try {
			list2 = totalService.adminPageSelectAdminAccount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("list", list2);
		
		return "test/adminAccount";
	}
	
	@GetMapping("/adminCharts")
	public String adminCharts()
	{
		return "test/adminCharts";
	}
	
	@GetMapping("/adminDocs")
	public String adminDocs(Model model)
	{
		//사용자 목록 가져오기 
		List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
		
		try {
			userList = totalService.adminPageSelectUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("userList", userList);
		return "test/adminDocs";
	}
	
	
	
	@GetMapping("/adminNotifications")
	public String adminNotifications()
	{
		return "test/adminNotifications";
	}
	
	@GetMapping("/adminOrders")
	public String adminOrders(Model model)
	{
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();
		
		try {
			shoesList = totalService.adminPageSelectShoesList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("shoesList", shoesList);
		return "test/adminOrders";
	}
	
	@GetMapping("/adminSettings")
	public String adminSettings()
	{
		return "test/adminSettings";
	}
	
	
}
