package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.Cart;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.CartMapper;
import com.example.rubypaper.mapper.UserMapper;

@Service
public class CartService {

	private final CartMapper cartMapper;
	
	@Autowired
	public CartService(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	
	public void cartInsert(Cart cart) throws Exception{
		cartMapper.cartInsert(cart);
	}
	
	
	
	
}
