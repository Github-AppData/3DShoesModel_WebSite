package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dao.UpdateDAO;

@Service
public class UpdateService {
	
	@Autowired
	UpdateDAO updateDAO;
	
	public int cartUpdateIsDelete(String shoes_id) {
		int cartUpdateIsDelete = 0;
		try {
			cartUpdateIsDelete = updateDAO.cartUpdateIsDelete(shoes_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartUpdateIsDelete;
	}
}
