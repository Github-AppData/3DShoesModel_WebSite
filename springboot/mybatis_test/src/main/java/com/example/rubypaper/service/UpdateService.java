package com.example.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubypaper.mapper.UpdateMapper;
import com.example.rubypaper.mapper.UserMapper;

@Service
public class UpdateService {
	private final UpdateMapper updateMapper;
	
	@Autowired
	public UpdateService(UpdateMapper updateMapper) {
		this.updateMapper = updateMapper;
	}
	
	public int cartUpdateIsDelete(String shoes_id) throws Exception{
		return updateMapper.cartUpdateIsDelete(shoes_id);
	}
}
