package com.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.container.Speaker;
@Component
public class SamsungTV implements TV {
	
	//1. 필드 주입방법
	@Autowired
	Speaker speaker;
	public SamsungTV(){
		System.out.println("===> SamsungTV");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setter 방식으로 주입");
	}

	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("생성자 방식으로 주입");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}

	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV volumeUp");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV volumeDown");
		speaker.volumeDown();
	}
}
