package com.example.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Shoes;
import com.example.rubypaper.mapper.SearchMapper;

@Service
public class SearchService {
	
	private final SearchMapper searchMapper;
	
	@Autowired
	public SearchService(SearchMapper shoesMapper) {
		this.searchMapper = shoesMapper;
	}
	
	public List<Shoes> Search(Shoes shoes) throws Exception{
		List<Shoes> searchResult = searchMapper.search(shoes);
		return searchResult;
	}
}
