package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.UserVO;

@Controller   // 자동으로 bean 등록하는 아노테이션(com.spring.web패키지 안에 있는 클래스에 @Controller 붙이면 자동으로 빈 등록된다)
@RequestMapping("/request")  // 공통 URI  // 그럼 아래 메서드들에서 /reqeust 전부 빼도 된다!
public class RequestController {
	
	// @RequestMapping : 이 URI로 들어왔을 때 아래 메서드를 작동시키겠다 
	@RequestMapping("/test")   // get인지 post인지 지정 안하면 뭐로 요청들어오든 작동한다
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴");
		return "test";
		
	}
	
	
	
	// 만약 /request/req 요청이 들어왔을 때 views폴더 아래의 request폴더의 req-ex01.jsp 파일을 열도록 메서드 구성
	
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청 들어옴");
		return "request/req-ex01";
	}
	
	
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.GET) // 회사에서는 이걸 더 많이쓴다
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청 들어옴 : GET");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청 들어옴 : POST");
		return "request/req-ex01";
	}
	
	
	
	
	
	
	
	
	
	// 요청메서드를 void 타입으로 지정하려면 URI랑 같은 경로에 해당하는 jsp파일이 존재해야!
		@GetMapping("/req-ex02")
		public void reqEx02() {
			System.out.println("/request/req-ex02 요청 들어옴");
		}
	
	
		
		
		
		
	
	
	
	////////////////////////////////////////////////////
	
	
		
		
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join 요청 들어옴 : GET");
	}
	
	
	
	
	
	/* 1. 전통적인 jsp/servlet의 파라미터 읽기처리 방법 : HttpServletRequest 객체 사용
	@PostMapping("/join")
	public String register(HttpServletRequest request) {
		System.out.println("/reqeust/join 요청 들어옴 : POST");
		
		System.out.println("ID: " + request.getParameter("userId"));
		System.out.println("PW: " + request.getParameter("userPw"));
		System.out.println("HOBBY: " + Arrays.toString(request.getParameterValues("hobby")));
		
		return "request/join";
	}
	
	*/
	 
	
	
	
	/*
	// 2. RequestParam 아노테이션을 이용한 요청 파라미터
	// @RequestParam("읽을 파라미터명") 타입 변수   형태로 나열
	// 근데 List 타입은 입력을 안하면 좀 귀찮아진다  // 저렇게 해도 되는데 커맨드(command) 쓰는게 제일 좋다
	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
						 @RequestParam("userPw") String pw,
						 @RequestParam(value="hobby", required=false, defaultValue="취미 없음") List<String> hobbys) {
		
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("HOBBY : " + hobbys.toString());
	}
	
	*/
	
	
	
	
	
	
	// 3. 커맨드 객체를 활용한 파라미터 처리 
	//   : 파라미터 이름이 VO객체의 필드명과 같으면 알아서 setter로 집어넣는다! -> getter로 꺼내서 쓰면 된다
	
	@PostMapping("/join")
	public void register(UserVO user) {
		
		System.out.println("ID : " + user.getUserId());
		System.out.println("PW : " + user.getUserPw());
		System.out.println("NAME : " + user.getUserName());
		System.out.println("HOBBY : " + user.getHobby());
		
	}
	
	
	
	
	@GetMapping("/quiz")
	public String quiz() {
		
		return "request/req-quiz";
	}
	
	
	@PostMapping("/quiz")
	public String quiz(UserVO user) {
		
		if(user.getUserId().equals("abc1234") && user.getUserPw().equals("1234")) {
			return "request/login-success";
		}else {
			return "request/login-fail";
		}
		
	}
}
