package com.spring.mvc.user.repository;

import com.spring.mvc.user.model.UserVO;

public interface IUserMappper {
	
	// 회원가입 기능
	void register(UserVO user);
	
}
