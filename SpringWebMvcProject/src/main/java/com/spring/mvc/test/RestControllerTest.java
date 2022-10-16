package com.spring.mvc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController  // @Controller + @ResponseBody 둘을 합친 것!  // 스프링4부터 사용 가능
@RequestMapping("/rest")
public class RestControllerTest {
	
	
	/*
	 	@ResponseBody:
	 	 리턴 데이터를 ViewResolver에게 전달하지 않고
	 	 클라이언트에게 해당 데이터를 바로 응답하게 한다
	  
	  */
	
	
	@GetMapping("/hello")
	//@ResponseBody
	public String hello() {
		return "Hello World!";   // 그럼 웹브라우저에 Hello World!라고 뜬다!
	}
	
	
	
	@GetMapping("/hobbys")
	//@ResponseBody
	public List<String> hobbys(){
		List<String> hobbys = Arrays.asList("축구", "수영", "음아감상");
		return hobbys;  // ["축구","수영","음아감상"] 이렇게 JSON 형태로 변환되서 출력!
	}
	
	
	
	@GetMapping("/study")
	//@ResponseBody
	public Map<String, Object> study(){
		Map<String, Object> subject = new HashMap<>();
		subject.put("자바", "java");
		subject.put("jsp", "Java Server Page");
		subject.put("Spring", "Spring FrameWork");
		return subject;   // {"jsp":"Java Server Page","자바":"java","Spring":"Spring FrameWork"}
	}
	
	
	
	
	@GetMapping("/person")
	@ResponseBody
	public Person person() {
		
		Person p = new Person();
		
		p.setName("홍길동");
		p.setAge(30);
		p.setHobbys(Arrays.asList("수영", "탁구", "요리"));
		
		return p;  // {"name":"홍길동","age":30,"hobbys":["수영","탁구","요리"]}
	}
	
	
	
	
	
	
	
	
	
	
}
