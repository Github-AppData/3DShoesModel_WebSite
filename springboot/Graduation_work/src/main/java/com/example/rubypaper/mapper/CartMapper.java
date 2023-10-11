package com.example.rubypaper.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.rubypaper.dto.Cart;


@Mapper
public interface CartMapper {

	public void cartInsert(Cart car);
	
	

	
}
