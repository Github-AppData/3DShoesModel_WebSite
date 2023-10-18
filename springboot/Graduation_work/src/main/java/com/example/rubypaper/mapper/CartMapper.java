package com.example.rubypaper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.Cart;


@Mapper
public interface CartMapper {
	
	public void cartInsert(Cart car);
	public String cartCheckShoesId(@Param("shoes_id") String shoes_id);
	public int numberOfCart();
}
