package com.joselcastillo.springdemo;

public class SwimCoach implements Coach_Interface {
	
	private FortuneService_Interface fortuneService;
	
	public SwimCoach(FortuneService_Interface theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim workout: Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return "Swim daily fortune says: " + fortuneService.getFortune();
	}

}
