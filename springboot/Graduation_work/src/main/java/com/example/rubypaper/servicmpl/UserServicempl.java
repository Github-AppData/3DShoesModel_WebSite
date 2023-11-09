package com.example.rubypaper.servicmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.UserMapper;
import com.example.rubypaper.service.UserService;


@Service
public class UserServicempl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void userInsert(User user) throws Exception {
		userMapper.userInsert(user);
	}

	@Override
	public void findAll(User user) throws Exception {
		userMapper.findAll(user);
	}

	@Override
	public User idCheckSelect2(String id) throws Exception {
		return userMapper.idCheckSelect2(id);
	}

	@Override
	public int newPwChange(User user) throws Exception {
		return userMapper.newPwChange(user);
	}

	@Override
	public User getSaltSelect(String id) throws Exception {
		return userMapper.getSaltSelect(id);
	}

	@Override
	public User getPwSelect(String id) throws Exception {
		return userMapper.getPwSelect(id);
	}

	@Override
	public int userInfoUpdate(User user) throws Exception {
		return userMapper.userInfoUpdate(user);
	}
	
}
