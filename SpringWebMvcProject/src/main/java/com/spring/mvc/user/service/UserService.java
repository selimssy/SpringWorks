package com.spring.mvc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMappper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMappper mapper;
	
	
	@Override
	public void register(UserVO user) {
		mapper.register(user);
	}

}
