package com.joselcastillo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Changed from the explicit "thatSillyCoach" bean id, to a default bean id by removing that name
public class TennisCoach implements Coach_Interface {

	private FortuneService_Interface fortuneService;
	
	// Constructor for injection
	@Autowired /* Spring will scan for a component that implements the FortuneService interface.
	For this project, it will be the class HappyFortuneService that meets this requirement. */
	public TennisCoach(FortuneService_Interface theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Your Tennis workout: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return "Tennis coach fortune says: " + fortuneService.getFortune() ;
	}
	

}
