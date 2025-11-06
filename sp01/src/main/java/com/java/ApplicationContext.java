package com.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.container.Applespeaker;
import com.container.Speaker;
import com.factory.SamsungTV;
import com.factory.TV;

@Configuration
public class ApplicationContext {

	@Bean
	public Speaker speaker() {
		return new Applespeaker();
	}
	@Bean
	public TV tv() {
		// 생성자방식
		return new SamsungTV(speaker());
		
		// setter방식
//		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
//		return tv;
	}
}
