package com.spring.basic.ex01;

public class Restaurant {

	private Chef chef;
	
	/*public Restaurant(Chef chef) {
		System.out.println("레스토랑이 생성됨!");
		this.chef = chef;
	}*/
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void orderDinner() {
		System.out.println("저녁 식사를 주문합니다.");
		chef.cook();
	}
}
