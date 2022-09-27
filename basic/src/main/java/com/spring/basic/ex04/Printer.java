package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


// import 단축기 컨트롤 + shift + 알파벳O


/*
  		@Autowired 
  		- 객체를 자동 주입할 때 사용하는 아노테이션
  		- 스캔명령을 통해 객체를 찾아 주입하는데, 타입이름으로 검색한다
  		- 타입을 찾아내지 못하면 이름(id속성값)으로 검색한다
  		- 생성자, 필드, 메서드에 적용 가능
  		- 필드에 자동주입 설정을 수행할 때는 기본생성자가 반드시 있어야!
  		
  		
  		@Qualifier("id속성값") 
  		- @Autowired를 사용할 때 동일 타입의 빈이 여러 개 있을 경우 어떤 빈을 주입해야 하는지 
  		  선택해주는 추가 아노테이션
  		- 단독으로 사용하지 않고 항상 @Autowired와 같이 사용한다
  		
  		
  		@Inject
  		- @Autowired과 동일
  		- 근데 pom.xml에서 관련 Maven 다운받아와야한다
  		- t) 상사가 @Inject쓰면 눈치껏 이거쓰고 아니면 @Autowired 쓰면된다
  		
  		
  		@Resource
  		- @Autowired 하고 @Qualifier("id속성값")를 한줄에 쓰는건데 JDK11부터는 지원X 
  		- @Resource(name="id속성값") 방식
  		- 필드, 메서드에만 가능(생성자에는 적용 불가)
  */



public class Printer {
	
	@Autowired 
	@Qualifier("paper1")
	private Paper paper;
	
	
	public Printer() {
	}
		
	
	//@Autowired     
	public Printer(Paper paper) {
		this.paper = paper;
	}
	
	
	//@Autowired     
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	public void showPaperInfo() {
		
		for(String info : paper.data) {
			System.out.println(info);
		}
		
	}
	
}
