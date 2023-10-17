package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Cart;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.CartMapper;
import com.example.rubypaper.mapper.UserMapper;


public interface CartService {
	
	public void cartInsert(Cart cart) throws Exception;
	public String cartCheckShoesId(String shoes_id) throws Exception;
	public int numberOfCart() throws Exception;
}
