package com.example.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.service.ShoesService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShoesController {
	
	@Autowired
	ShoesService shoesService;
	
	@PostMapping("/sMain/search")
	public String searchTest(Shoes shoes) throws Exception{
		List<Shoes> shoesList = shoesService.Search(shoes);
		System.out.println(shoesList.size());
		for(int i = 0; i < shoesList.size(); i++)
		{
			System.out.println(shoesList.get(i).toString());
		}
		
		//System.out.println(shoesList);
		return "test/sMain";
	}
	@GetMapping("/sMain/search")
	public String searchTest2(Model model) throws Exception{
		return "test/sMain";
	}
}
