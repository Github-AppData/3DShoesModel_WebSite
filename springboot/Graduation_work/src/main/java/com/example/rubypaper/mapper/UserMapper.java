package com.example.rubypaper.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.User;

@Mapper
public interface UserMapper {
	
	public void userInsert(User user);
	public void findAll(User user);
	public User idCheckSelect2(@Param("id") String id);
	public int newPwChange (User user);
	public User getSaltSelect(@Param("id") String id);
	public User getPwSelect(@Param("id") String id);
	public int userInfoUpdate(User user);
	public int noticeBoardIdxResort() throws Exception;
}
