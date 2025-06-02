package com.jwt.security.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.security.config.SecurityConfig;
import com.jwt.security.entity.UserInfo;
import com.jwt.security.repo.UserRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	SecurityConfig securityConfig;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userRepo.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not Found");
		return new User(user.getUserName(), user.getPassword(), Collections.singleton(() -> "ROLE_" + user.getRole()));
	}

}
