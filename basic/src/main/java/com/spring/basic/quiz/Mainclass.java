package com.spring.basic.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {
				
		/*
		  	1. quiz-config.xml에서 Monitor, Mouse, Keyboard, Computer 빈을 생성 후
		  	2. Computer 클래스에서 자동 주입을 설정
		  	3. xml에서 빈을 얻은 후 comuterInfo() 메서드 실행
		*/
		
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:quiz-config.xml");
		
		Computer computer = ct.getBean("computer", Computer.class);
		computer.computerInfo();
		
		
		ct.close();
	}

}
