package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.web.model.BirthVO;

@Controller
public class BirthController {
	
	// 생일을 입력하는 폼을 열어주는 요청메서드
	@GetMapping("/birth")
	public String birthForm() {
		
		return "birth/birth-form";
	}
	
	
	// 생일정보를 result 페이지에 전달하는 요청메서드
	@PostMapping("/birth")
	public String sendBirth(@ModelAttribute("birth") BirthVO birth) {
		
		System.out.println(birth.getYear() + birth.getMonth() + birth.getDay());
		
		return "birth/birth-result";
	}
	
}
