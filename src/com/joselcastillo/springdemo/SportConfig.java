package com.joselcastillo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration /* This tells Spring that this is a Java configuration file and that it should follow
the appropriate rules in this configuration file */
/* @ComponentScan("com.joselcastillo.springdemo") /* Parameter should be the name of the package that we want
Spring to start scanning */ // Commented out @Component Scan since currently I want to do that with Java code
public class SportConfig {
	
	/* 2). Inject the bean dependencies
	       Define the bean for our sad fortune service
	       The method name will be the "bean id" used by Spring to register it with the application context.
	  	   Then, we'll use it to pass it in the method below and inject it (happyFortuneService()), and Spring
	       will intercept it and handle it based on the bean configuration. */
	@Bean
	public FortuneService_Interface sadFortuneService() {
		return new SadFortuneService();
	}
	
	/* 1). Define a method to expose the bean using Java source code only
	      So, we define a bean for our swim coach AND inject the dependency.*/
	@Bean
	public Coach_Interface swimCoach() { // This method name will be the "bean id". No 'component scan' used
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService()); /* Create a new instance of this method,		
																       and inject the bean dependency 
																       sadFortuneService() */
		return mySwimCoach;
	}
}
