package com.joselcastillo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// 3). Make use of the Spring Java source code configuration file recently created (SportConfig)
		// by reading it
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// 4). Get the bean from the Spring application container/context
		// Changed from passing the explicit "thatSillyCoach" bean id, to a default bean id 'tennisCoach'
		// (which should be the class name in use but with the first letter converted to lower case)
		SwimCoach theCoach = appContext.getBean("swimCoach", SwimCoach.class);
		
		// Call some methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call new method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Call our new swim coach methods which have the properties values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// Close the application context
		appContext.close();
		
	}

}

/* SAMPLE OUTPUT 1
   ---------------
   
    Swim workout: Swim 1000 meters as a warm up
	Swim daily fortune says: SadFortuneService says, Today is a sad day

   
   
*/ 