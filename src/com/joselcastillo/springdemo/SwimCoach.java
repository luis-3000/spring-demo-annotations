package com.joselcastillo.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach_Interface {
	
	private FortuneService_Interface fortuneService;
	
	// Inject/reference values from the properties file
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	// Constructor injection
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
	
	// Make use of the fields referencing the value sin the properties file
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
