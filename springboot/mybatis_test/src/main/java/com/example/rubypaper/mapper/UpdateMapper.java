package com.example.rubypaper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateMapper {
	public int cartUpdateIsDelete(@Param("shoes_id") String shoes_id);
}
