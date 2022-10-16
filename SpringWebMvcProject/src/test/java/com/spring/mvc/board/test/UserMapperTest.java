package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMappper;

@RunWith(SpringJUnit4ClassRunner.class)  // 이거 쓰려면 Spring Test 모듈 maven 주입해야
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMappper mapper;
	
	
	@Test
	public void register() {
		
		UserVO user = new UserVO();
		user.setAccount("abc1234");
		user.setPassword("1234");
		user.setName("홍길동");
		
		mapper.register(user);
		System.out.println("회원가입 성공!");
		
		
	}
}
