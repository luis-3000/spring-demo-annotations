package com.joselcastillo.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach_Interface {

	@Autowired
	@Qualifier("fileFortuneService") // or is it "randomFortuneService" ?
	private FortuneService_Interface fortuneService;
	
//	// define a default constructor
//	public PingPongCoach() {
//		System.out.println(">> PingPongCoach class: inside default constructor PingPongCoach()");
//	}
//	
//	// Define the init method
//	@PostConstruct // This instructs Spring to execute after the constructor and after injection of dependencies
//	public void doMyStartupStuff() {
//		System.out.println(" >> PingPongCoach class: inside the doMyStartupStuff() method");
//	}
//	
//	// Define the destroy method
//	@PreDestroy // This instructs Spring to execute the Code before the bean is destroyed
//	public void doMyCleanupStuff() {
//		System.out.println(" >> PingPongCoach class: inside the doMyCleanupStuff() method");
//	}
		
	@Override
	public String getDailyWorkout() {
		return "PingPong Workout: Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		return "PingPong fortune says: " + fortuneService.getFortune();
	}

}
