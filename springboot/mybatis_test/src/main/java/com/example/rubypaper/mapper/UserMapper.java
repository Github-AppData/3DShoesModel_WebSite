package com.example.rubypaper.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rubypaper.dto.User;

@Mapper
public interface UserMapper {
	
	public void userInsert(User user);

	public void findAll(User user);
	
	// 객체가 아닌 일반 자료형을 담을 때는 @Param을 써야 한다.
	public User idCheckSelect2(@Param("id") String id);
	
	public User newPwChange (@Param("pw") String pw, @Param("salt") String salt, @Param("id") String id);

	public User getSaltSelect(@Param("id") String id);
	public User getPwSelect(@Param("id") String id);
	
	
}
