package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.UserMapper;



@Service
public class UserService {
	
	private final UserMapper userMapper;
	

	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void userInsert(User user) throws Exception{
		userMapper.userInsert(user);
	}
	
	public void findAll(User user) throws Exception{
		userMapper.findAll(user);
	}
	
	public User idCheckSelect2(String id) throws Exception {
	    return userMapper.idCheckSelect2(id);
	}
	
	public User newPwChange(String pw, String salt, String id) throws Exception {
	    return userMapper.newPwChange(pw, salt, id);
	}
	
	public User getSaltSelect(String id) throws Exception {
	    return userMapper.getSaltSelect(id);
	}
	
	public User getPwSelect(String id) throws Exception {
	    return userMapper.getPwSelect(id);
	}
	
	
	
}
