package com.spring.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller("resCon")  //빈의 id를 부여하고 싶을 때
@RequestMapping("/response")  // 공통 URI
public class ResponseController {
	
	
	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	
	
	// 1. Model 객체를 사용하여 화면에 데이터 전송하기
	
	/*@GetMapping("/test")
	public String test(@RequestParam("age") int age, Model model) {
		
		model.addAttribute("nick", "뽀삐");  // test.jsp로 안내하기 전에 nick 데이터를 들고간다!
		model.addAttribute("age", age);
		
		return "response/test";
	} */
	
	
	
	// 2. @ModelAttribute 를 사용한 화면에 데이터 전송처리
	@GetMapping("/test")
	public String test(@ModelAttribute("age") int age, Model model) {
		
		// @ModelAttribute : @RequestParam 하고 model.addAttribute를 한번!!
		model.addAttribute("nick", "뽀삐");  // test.jsp로 안내하기 전에 nick 데이터를 들고간다!
		//model.addAttribute("age", age);
		
		return "response/test";
	}
	
		
	
	// 3.ModelAndView객체를 활용한 처리
	@GetMapping("/test2")
	public ModelAndView test2() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", "김돌돌");
		mv.setViewName("response/test2");  // t는 /response/test2로 했는데 뭐가 정석이지,,
		
		return mv;
		
		
		/*
		  줄여서 return new ModelAndView("response/test2", "userName", "김돌돌");
		  이렇게 한 줄로써도 된다!!
		  담을 데이터 많으면 Map 타입에 넣어서 준다
		  */
	}
	
	
	
	
	
	
	
	// res-ex02.jsp 파일을 열람하는 요청메서드 작성
	@GetMapping("/res-ex02")
	public void resEx02() {
		
	}
	
	
	@PostMapping("/join")
	public String join(UserVO user, Model model) {
		
		model.addAttribute("user", user);   // userVO객체를 통째로 담아서 test.jsp로 보낸다!
		
		return "response/test3";
	}
	
	/*
	 * 이렇게 @ModelAttribute로 할 수도 있다
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user) {
		
		return "response/test3";
	}
	*/
	
	
	
	
	@GetMapping("/res-quiz")
	public void resQuiz() {
		
	}
	
	
	@PostMapping("/res-quiz")
	public String resQuiz(@ModelAttribute("user") UserVO user) {
		
		if(user.getUserId().equals("abc1234") && user.getUserPw().equals("1234")) {
			return "response/res-quiz-success";
		}else {
			return "response/res-quiz-fail";
		}
		
	}
	
	
	
	/* t방식~!
	//@ModelAttribute를 사용한 방식
		@PostMapping("/res-login")
		public String resLogin(@ModelAttribute("userId") String id
							, @RequestParam("userPw") String pw) {	
		
			if(id.equals("kim123") && pw.equals("kkk1234")) {
				return "response/res-quiz-success";
			} else {
				return "response/res-quiz-fail";
			}
		}
	
	*/
	
	
	
	///////////////////////////////////////////////////////////////////
	
	
	/* Redirect 처리
	 * 
		- Model은 request범위!! model.addAttribute도 request 범위에서만 사용 가능해서 
		  redirect하면 데이터 안넘어간다!
		 
		- Session은 너무 광범위해서 새로고침해도 데이터가 그대로 남아있는 등의 문제 등으로 부적합
	
		- RedirectAttribute :  redirect할 때만 1회성으로 redirect 페이지로 넘겨주는 용도!!
		  메서드 파라미터에 RedirectAttributes ra 적고
		  ra.addFlashAttribute("이름지정", 넣을 데이터) 형태
	*/
	//로그인 화면 요청처리
	@GetMapping("/login")
	public String login() {
		System.out.println("/response/login 요청 들어옴 : Get");
		return "response/res-redirect-form";
	}
	
	
	//로그인 검증처리
	@PostMapping("/login")
	public String login(@ModelAttribute("userId") String id,
						@RequestParam("userPw") String pw,
						@RequestParam("userPwChk") String pwChk,
						RedirectAttributes ra) {
		
		System.out.println("/response/login 요청 들어옴 : Post");
		
		if(id.equals("")) {
			//model.addAttribute("msg", "아이디는 필수입력 값이에요!");  
			//session.setAttribute("msg", "아이디는 필수입력 값이에요!");
			ra.addFlashAttribute("msg", "아이디는 필수입력 값이에요!");
			return "redirect:/response/login";  // redirect: 하고 컨텍스트루트 제외한 경로 적는다  // redirect는 무조건 get요청!
		}else if(!pw.equals(pwChk)) {
			ra.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "redirect:/response/login";
		}else if(id.equals("abc1234") && pw.equals("1234")) {
			return "response/res-quiz-success";
		}else {
			return null;
		}		
			
		
	}
	
	
	
	
	
	
	
	

}
