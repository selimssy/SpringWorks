package com.spring.mvc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	// 회원가입 요청 처리
	// Rest-api에서 INSERT : POST방식 (SELECT는 주로 GET, UPDATE는 PUT, DELETE는 DELETE)
	@PostMapping("/")
	public String register(UserVO user) {
		System.out.println("/user/ 요청 : POST");
		System.out.println("param : " + user);
		
		service.register(user);
		return "joinSuccess";
	}
	
}
