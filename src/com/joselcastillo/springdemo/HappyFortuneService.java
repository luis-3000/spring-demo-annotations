package com.joselcastillo.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService_Interface {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
