package com.example.rubypaper.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.NoticeBoard;
import com.example.rubypaper.dto.User;
import com.example.rubypaper.mapper.UserMapper;

public interface UserService {

	public void userInsert(User user) throws Exception;
	public void findAll(User user) throws Exception;
	public User idCheckSelect2(String id) throws Exception;
	public int newPwChange(User user) throws Exception;
	public User getSaltSelect(String id) throws Exception;
	public User getPwSelect(String id) throws Exception;
	public int userInfoUpdate(User user) throws Exception;
	
}
