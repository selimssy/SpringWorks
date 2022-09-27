package com.spring.basic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	
	public static void main(String[] args) {
		
		//System.out.println("안녕스프링~");
		
		//SpringTest st = new SpringTest();
		//st.hello();
		
		GenericXmlApplicationContext ct =
		new GenericXmlApplicationContext("classpath:test-config.xml");   //resorces 폴더에 접근할 때: classpath
		
		SpringTest st = ct.getBean("test", SpringTest.class);  // id이름, 어떤 형태로 가져올지
		st.hello();
		
		ct.close();
	}
	
}
