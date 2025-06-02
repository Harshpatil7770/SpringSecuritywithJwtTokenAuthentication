package com.jwt.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.security.config.SecurityConfig;
import com.jwt.security.entity.UserInfo;
import com.jwt.security.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	SecurityConfig securityConfig;
	
	public String save(UserInfo newUserInfo) {
		UserInfo existingUser = userRepo.findByUserName(newUserInfo.getUserName());
		if (existingUser != null) {
			log.info("UserName already exist ! {} ", existingUser.getUserName());
			return "UserName already exist !";
		}
		String encodedPassword=securityConfig.passwordEncoder().encode(newUserInfo.getPassword());
		newUserInfo.setPassword(encodedPassword);
		userRepo.save(newUserInfo);
		log.info("User Added Succesfully ! {} ", newUserInfo.getUserName());
		return "User Added Succesfully !";
	}
}
