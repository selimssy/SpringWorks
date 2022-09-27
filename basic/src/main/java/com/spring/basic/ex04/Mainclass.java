package com.spring.basic.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {
		
		/*Printer printer = new Printer(new Paper());
		printer.showPaperInfo();*/
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:auto-config.xml");
		
		Printer prt = ct.getBean("prt", Printer.class);
		prt.showPaperInfo(); 
		
		ct.close();
	}

}
