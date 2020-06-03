package com.joselcastillo.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Changed from the explicit "thatSillyCoach" bean id, to a default bean id by removing that name
public class TennisCoach implements Coach_Interface {

	@Autowired
	@Qualifier("randomFortuneService")
	// Use the @Qualifier annotation and indicate the bean id that you want to use
	// in order to force the correct dependency injection
	private FortuneService_Interface fortuneService;
	
	
//	// Constructor for injection
//	@Autowired /* Spring will scan for a component that implements the FortuneService interface.
//	For this project, it will be the class HappyFortuneService that meets this requirement. 
//	NOTE: as of Spring 4.3 an @Autowired annotation on a constructor is no longer necessary if the 
//	target bean only defines one constructor to begin with. However, if several constructors are
//	available, at least one must be annotated to teach the container which one to use.*/
//	public TennisCoach(FortuneService_Interface theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	// The above injection constructor is no longer needed since we'll be doing setter methods
	// dependency injection
	// Define a Default Constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach class: inside the default constructor TennisCoach()");
	}
	
	// Define the init method
	@PostConstruct // This instructs Spring to execute after the constructor and after injection of dependencies
	public void doMyStartupStuff() {
		System.out.println(" >> TennisCoach class: inside the doMyStartupStuff() method");
	}
	
	// Define the destroy method
	@PreDestroy // This instructs Spring to execute the Code before the bean is destroyed
	public void doMyCleanupStuff() {
		System.out.println(" >> TennisCoach class: inside the doMyCleanupStuff() method");
	}
	
	
//	// Define a setter method for dependency injection
//	@Autowired // Tells Spring "I want you to autowire this dependency using this setter method"
//	public void setFortuneService(FortuneService_Interface theFortuneService) {
//		System.out.println(">> TennisCoach class: inside the setter method setFortuneService()"); 
//		fortuneService = theFortuneService;
//	}
	
//	/* The above setter method for injection is no longer needed since we're trying to do dependency injection
//	 * via any method in the class. All we have to do is create any method, put the @Autowired annotation above it,
//	 * and then assign the corresponding dependency inside it. */
//	@Autowired
//	public void anyMethodToPerformTheDependencyInjection(FortuneService_Interface theFortuneService) {
//		System.out.println(">> TennisCoach class: inside the method anyMethodToPerformTheDependencyInjection()");
//		this.fortuneService = theFortuneService;
//	}
	
	/* The above method is no longer needed to do the dependency injection since we can inject the dependencies
	 * by setting the field values in the class directly (even private fields) with the @Autowired annotation. 
	 * So, that'll be done at the beginning of the class. */
	
	@Override
	public String getDailyWorkout() {
		return "Your Tennis workout: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return "Tennis coach fortune says: " + fortuneService.getFortune() ;
	}
		

}
