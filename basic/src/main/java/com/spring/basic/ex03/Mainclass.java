package com.spring.basic.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {
	
	public static void main(String[] args) {
		
		/* ct.getBean을 통해 객체 꺼내올 때 default는 싱글톤!!
		   꺼낼올 때마다 새로운 객체 생성하려면 scope = "prototype" 설정 해줘야한다!
		 */
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:prototype-config.xml");
		
		Person hong = ct.getBean("person", Person.class);
		
		Person kim = ct.getBean("person", Person.class);
		
		System.out.println("hong의 주소 : " + hong);
		System.out.println("kim의 주소 : " + kim);
		System.out.println("hong과 kim은 같은 객체인가? " + (hong == kim));
		
		System.out.println("----------------------------------------");
		kim.setName("김철수");
		kim.setAge(25);
		
		System.out.println("hong의 이름 : " + hong.getName()); 
		System.out.println("hong의 나이 : " + hong.getAge()); 
		System.out.println("kim의 이름 : " + kim.getName()); 
		System.out.println("kim의 나이 : " + kim.getAge()); 
		
		
		ct.close();
	}

}
