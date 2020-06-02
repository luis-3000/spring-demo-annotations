package com.joselcastillo.springdemo;

import org.springframework.stereotype.Component;

//Pass in the bean id we want to use, to the @Component annotation
@Component("thatSillyCoach")
public class TennisCoach implements Coach_Interface {

	@Override
	public String getDailyWorkout() {
		return "Your Tennis workout: Practice your backhand volley";
	}

}
