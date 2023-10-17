package com.example.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.SearchService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@PostMapping("/test_Search")
	public String searchTest(Model model, HttpServletRequest request, HttpSession session) throws Exception{
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();
		
		try {
			shoesList = searchService.searchShoes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(shoesList != null){
			
			for(int i = 0; i < shoesList.size(); i++)
			{
				System.out.println(shoesList.get(i).toString());
			}
			
			
			model.addAttribute("result",shoesList);
			return "test/test_Search";
		}
		else {
			return "test/sMain";
		}
	}
}
