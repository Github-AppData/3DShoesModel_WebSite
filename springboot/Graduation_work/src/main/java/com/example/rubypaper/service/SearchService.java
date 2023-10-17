package com.example.rubypaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dao.TotalDAO;


@Service
public class SearchService {
	
	@Autowired
	TotalDAO totalDAO;
	
	public List<Map<String, Object>> searchShoes() {
		List<Map<String, Object>> shoesList = new ArrayList<Map<String, Object>>();

		try {
				shoesList = totalDAO.search();
			} catch (Exception e) {
				e.printStackTrace();
			}
				return shoesList;
	}
}
