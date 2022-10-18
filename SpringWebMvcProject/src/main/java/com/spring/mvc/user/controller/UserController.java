package com.spring.mvc.user.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	
	// 아이디 중복확인 요청 처리
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		
		System.out.println("/user/checkId 요청 : POST");
		System.out.println("param : " + account);
		String result = null;
		
		Integer checkNum = service.checkId(account);
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨!");
			result = "NO";
		}else {
			System.out.println("아이디 사용가능!");
			result = "OK";
		}
		
		return result;
		
	}
	
	
	
	
	// 로그인 요청 처리
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO user,
							 /*HttpServletRequest request*/
			                  HttpSession session,
			                  HttpServletResponse response) {
		
		// 서버에서 세션객체를 얻는 방법
		// 1. HttpServletRequest 객체 사용
		//HttpSession session = request.getSession(); // 한번 돌아가는 방법이긴 하지만 외부 API 사용시 request 객체만 쓸 수 있는 경우를 대비해 알아둬야!
		// 2. HttpSession 객체 사용
		    // -> 파라미터에 HttpSession session 해서 바로 session. 으로 사용
		
		String result = null;
		
		/*
		  # 클라이언트가 전송한 id값과 pw값을 가지고 DB에서 회원의 정보를 조회해서
		    불러온 다음 값 비교를 통해
		     1. 아이디가 없을 경우 클라이언트 측으로 문자열 "idFail" 전송
		     2. 비밀번호가 틀렸을 경우 문자열 "pwFail" 전송
		     3. 로그인 성공시 문자열 "loginSuccess" 전송
		  */

		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserVO dbUser = service.selectOne(user.getAccount());
		
		System.out.println(user);
		System.out.println(dbUser);
		
		if(dbUser == null) {
			result = "idFail";
		}else {
			if(encoder.matches(user.getPassword(), dbUser.getPassword())) {
				session.setAttribute("login", dbUser);
				result = "loginSuccess";
				
				long limitTime = 60 * 60 * 24 * 90;
				
				// 자동로그인 체크시 처리
				if(user.isAutoLogin()) {
					
					System.out.println("자동로그인 쿠키 생성중...");
					
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/"); // 쿠키경로
					loginCookie.setMaxAge((int)limitTime);
				
					response.addCookie(loginCookie); // 서버에서 생성한 쿠키를 클라이언트에게 보내줌
				}
				
				
			}else {
				result = "pwFail";
			}
		}
		
		return result;
	}
	
	
	
	
	
	// 로그아웃 요청 처리
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {  // @RestController 에서도 뷰리졸버 써야될 땐 ModelAndView로!!★
		
		UserVO user = (UserVO)session.getAttribute("login"); // getAttribute 반환타입이 Object라서 다운캐스팅해야! 
		
		if(user != null) {
			session.removeAttribute("login");  // 좀더 확실하게 처리하기 위해
			session.invalidate();
		}
		
		return new ModelAndView("redirect:/");  
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
