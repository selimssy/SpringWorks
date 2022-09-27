package com.spring.web.model;

public class BirthVO {
	
	private String year;
	private String month;
	private String day;
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		
		if(Integer.parseInt(month) < 10) {
			this.month = "0" + month;  // 숫자 + 문자는 문자형이라서 쌍따옴표 안해도 되긴하다
			return;  // 아니면 else로 처리해도 된다
		}	
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		if(Integer.parseInt(day) < 10) {
			this.day = "0" + day;  
			return;  
		}	
		this.day = day;
	}
	
}
