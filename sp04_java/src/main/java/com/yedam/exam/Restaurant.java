package com.yedam.exam;

public class Restaurant {
	
	Chef chef;
	

	public Restaurant(Chef chef) {
		super();
		this.chef = chef;
	}


	public void order() {
		chef.cook();
	}
}
