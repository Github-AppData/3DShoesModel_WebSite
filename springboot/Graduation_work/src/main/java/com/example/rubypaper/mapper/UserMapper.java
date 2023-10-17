package com.example.rubypaper.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.User;

@Mapper
public interface UserMapper {
	
	public void userInsert(User user);
	public void findAll(User user);
	public User idCheckSelect2(@Param("id") String id);
	public User newPwChange (@Param("pw") String pw, @Param("salt") String salt, @Param("id") String id);
	public User getSaltSelect(@Param("id") String id);
	public User getPwSelect(@Param("id") String id);
}
