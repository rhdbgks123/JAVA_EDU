package com.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.factory.TV;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
		
		TV tv = (TV)context.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
	}

}
