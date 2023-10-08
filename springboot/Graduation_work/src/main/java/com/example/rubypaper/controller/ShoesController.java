package com.example.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.SearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShoesController {
	
	@Autowired
	SearchService shoesService;
	
	@PostMapping("/test_Search")
	public String searchTest(@ModelAttribute Shoes shoes, Model model) throws Exception{
		List<Shoes> shoesList = shoesService.Search(shoes);
		
		if(shoesList != null){
			model.addAttribute("result",shoesList);
			return "test/test_Search";
		}
		else {
			return "test/sMain";
		}
		/*
		System.out.println(shoesList.size());
		for(int i = 0; i < shoesList.size(); i++)
		{
			System.out.println(shoesList.get(i).toString());
		}
		*/
		//System.out.println(shoesList);
	}
}
