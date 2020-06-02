package com.joselcastillo.springdemo;

import org.springframework.stereotype.Component;

@Component // Changed from the explicit "thatSillyCoach" bean id, to a default bean id by removing that name
public class TennisCoach implements Coach_Interface {

	@Override
	public String getDailyWorkout() {
		return "Your Tennis workout: Practice your backhand volley";
	}

}
