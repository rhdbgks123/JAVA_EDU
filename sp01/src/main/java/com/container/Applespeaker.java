package com.container;

import org.springframework.stereotype.Component;

@Component
public class Applespeaker implements Speaker{
    public Applespeaker() {
        System.out.println("===> AppleSpeaker");
    }    
    public void volumeUp() {
        System.out.println("AppleSpeaker volumeUp.");
    }
    public void volumeDown() {
        System.out.println("AppleSpeaker volumeDown.");
    }
}
