package com.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.entity.UserInfo;
import com.jwt.security.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<String> register(@RequestBody UserInfo newUserInfo) {
		String response = userService.save(newUserInfo);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/info")
	public ResponseEntity<String> getInfo(){
		return new ResponseEntity<String>("Hello !!!", HttpStatus.OK);
	}
}
