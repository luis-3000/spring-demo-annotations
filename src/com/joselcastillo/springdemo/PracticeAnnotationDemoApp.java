package com.joselcastillo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach_Interface theCoach = appContext.getBean("pingPongCoach", Coach_Interface.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method on the bean
		System.out.println(theCoach.getDailyFortune());

		// close the context
		appContext.close();
		
	}

}

/* SAMPLE OUTPUT
 
 	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	>> PingPongCoach class: inside default constructor PingPongCoach()
	 >> PingPongCoach class: inside the doMyStartupStuff() method
	PingPong Workout: Practice your pingpong drop shot
	PingPong fortune says: Beware of the wolf.
	 >> PingPongCoach class: inside the doMyCleanupStuff() method
 

   SECOND SAMPLE OUTPUT

	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	>> PingPongCoach class: inside default constructor PingPongCoach()
	 >> PingPongCoach class: inside the doMyStartupStuff() method
	PingPong Workout: Practice your pingpong drop shot
	PingPong fortune says: Today is your lucky day.
	 >> PingPongCoach class: inside the doMyCleanupStuff() method


	THIRD SAMPLE OUTPUT
	
	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	>> PingPongCoach class: inside default constructor PingPongCoach()
	 >> PingPongCoach class: inside the doMyStartupStuff() method
	PingPong Workout: Practice your pingpong drop shot
	PingPong fortune says: Today is your lucky day.
	 >> PingPongCoach class: inside the doMyCleanupStuff() method

*/