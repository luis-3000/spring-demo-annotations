package com.joselcastillo.springdemo;

public class SadFortuneService implements FortuneService_Interface {

	@Override
	public String getFortune() {
		return "SadFortuneService says, today is a sad day";
	}

}
