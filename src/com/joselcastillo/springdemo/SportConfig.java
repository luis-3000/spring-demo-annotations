package com.joselcastillo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration /* This tells Spring that this is a Java configuration file and that it should follow
the appropriate rules in this configuration file */
/* @ComponentScan("com.joselcastillo.springdemo") /* Parameter should be the name of the package that we want
Spring to start scanning */ // Commented out @Component Scan since currently I want to do that with Java code
// Load the properties file in the Spring configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	/* 2). Inject the bean dependencies
	       But first, define the bean for our sad fortune service
	       The method name will be the "bean id" used by Spring to register it with the Spring application 
	       context/container.
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
		return new SwimCoach(sadFortuneService()); /* Create a new instance of this method,	and inject the 
													  bean dependency sadFortuneService() */
	}
}
