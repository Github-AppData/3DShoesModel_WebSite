package com.practice.jpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jpa.Entity.User;

public interface UserInfoRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
	List<User> findAll();
}
