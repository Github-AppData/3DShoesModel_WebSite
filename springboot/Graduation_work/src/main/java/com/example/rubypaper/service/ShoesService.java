package com.example.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.mapper.ShoesMapper;

@Service
public class ShoesService {
	
	private final ShoesMapper shoesMapper;
	
	@Autowired
	public ShoesService(ShoesMapper shoesMapper) {
		this.shoesMapper = shoesMapper;
	}
	
	public List<Shoes> Search(Shoes shoes) throws Exception{
		List<Shoes> searchResult = shoesMapper.search(shoes);
		return searchResult;
	}
}
