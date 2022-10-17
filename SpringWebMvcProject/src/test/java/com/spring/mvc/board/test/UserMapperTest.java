package com.spring.mvc.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	
	
	@Test
	public void deleteTest() {
		String account = "abc1234";
		mapper.delete(account);
		System.out.println("회원탈퇴 성공!");
	}
	
	
	
	
	@Test
	public void loginTest() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String inputId = "abc1234";
		String inputPw = "abc1234!!";
		
		UserVO dbUser = mapper.selectOne(inputId);
		String dbPw = dbUser.getPassword();
		
		System.out.println("입력된 비밀번호 : " + inputPw);
		System.out.println("DB에 등록된 비밀번호 : " + dbPw);
				
		// 이렇게하면 matches함수 내부에서 dbPw를 디코딩해서 둘을 비교한다!(treu, false로 리턴)
		System.out.println("비밀번호 일치 여부 : " + encoder.matches(inputPw, dbPw));
		
	}
	
	
	
	
}
