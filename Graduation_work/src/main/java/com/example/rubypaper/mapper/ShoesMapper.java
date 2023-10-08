package com.example.rubypaper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rubypaper.dto.Shoes;

@Mapper
public interface ShoesMapper {
	public List<Shoes> search(Shoes shoes) throws Exception;
}
