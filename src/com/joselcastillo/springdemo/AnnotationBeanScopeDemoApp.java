package com.joselcastillo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the Spring configuration file
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the Bean from the Spring Container
		Coach_Interface theCoach = appContext.getBean("tennisCoach", Coach_Interface.class);
		
		Coach_Interface alphaCoach = appContext.getBean("tennisCoach", Coach_Interface.class);
		
		// Check if these beans are pointing to the same object/memory location
		boolean pointToSameObject = (theCoach == alphaCoach);
		
		// Print out whether those Beans point to the same object/memory location
		System.out.println("\nDo the new beans point to the same object / memory location?  " + pointToSameObject);
		
		System.out.println("\nMemory location for theCoach:  " + theCoach);
		
		System.out.println("\nMemory location for alphaCoach:  " + alphaCoach + "\n");
		
		// Close the application context
		appContext.close();

	}

}
