package com.spring.basic.ex03;

public class Person {
	
	private String name;
	private Integer age;  // 최근 자바의 추세는 int도 객체형태로(Wrapper클래스 형태)..
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
