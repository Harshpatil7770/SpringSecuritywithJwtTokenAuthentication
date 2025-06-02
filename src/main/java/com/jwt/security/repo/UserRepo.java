package com.jwt.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.security.entity.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, String>{

	UserInfo findByUserName(String username);

}
