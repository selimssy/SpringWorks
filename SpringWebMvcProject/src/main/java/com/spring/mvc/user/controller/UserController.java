package com.spring.mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String register(@RequestBody UserVO user) { //@RequestBody: form이 아닌 요청body의 데이터를 읽기 위한 아노테이션
		System.out.println("/user/ 요청 : POST");
		System.out.println("param : " + user);
		
		service.register(user);
		return "joinSuccess";
	}
	
	
	
	
	// 회원탈퇴 요청 처리
	//@RequestMapping(value="/", method=RequestMethod.DELETE)   // 이 방법 잊지말자ㅋㅋ
	@DeleteMapping("/{account}")
	public String delete(@PathVariable String account) {
		System.out.println("/user/" + account + " 요청 : DELETE" );
		
		service.delete(account);   // 실제로는 이렇게 계정명으로 삭제하지 말고 회원별 id 시퀀스 부여해서 idNum으로 삭제하자! (account는 unique처리)
		return "delSuccess";
	}
	
	
	
	
	// 회원정보 조회 요청 처리
	@GetMapping("/{account}")
	public UserVO selectOne(@PathVariable String account) {
		System.out.println("/user/" + account + " 요청 : GET" );
		
		UserVO user = service.selectOne(account);  // 앞으론 return에 합쳐서 쓰자~
		return user;
	}
	
	
	
	
	// 전체회원 조회 요청 처리
	@GetMapping("/")
	public List<UserVO> selectAll(){
		System.out.println("/user/ 요청 : GET");
		
		return service.selectAll();
	}
	
	
}
