package com.spring.basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	
	@Autowired
	private Monitor monitor;	
	@Autowired
	private Keyboard keyboard;
	@Autowired
	private Mouse mouse;
	
	
	public void computerInfo() {
		System.out.println("*** 켬퓨터 정보 ***");
		monitor.info();
		keyboard.info();
		mouse.info();
	}
	
}
