package com.spring.mvc.user.service;

import com.spring.mvc.user.model.UserVO;

public interface IUserService {

	// 회원가입 기능
		void register(UserVO user);
		
}
