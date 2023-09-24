package com.practice.jpa;

import org.springframework.stereotype.Service;

import com.practice.jpa.Entity.User;
import com.practice.jpa.Repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserInfoRepository userInfoRepository;
	
	public DefaultResponseDTO insertUser(UserInfoRequestDTO userInfo) {
		User user = new User();
		
		user.setEmail(userInfo.getEmail());
		user.setName(userInfo.getName());
		user.setPassword(encryptPW);
		
		userInfoRepository.save(user);
		return new DefaultResponseDTO("회원가입 성공");
	}
}
