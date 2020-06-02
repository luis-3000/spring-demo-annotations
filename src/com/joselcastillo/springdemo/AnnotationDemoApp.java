package com.joselcastillo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// Read the Spring configuration file
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from the Spring container
		// Changed from passing the explicit "thatSillyCoach" bean id, to a default bean id 'tennisCoach'
		// (which should be the class name in use but with the first letter converted to lower case)
		Coach_Interface theCoach = appContext.getBean("tennisCoach", Coach_Interface.class);
		
		// Call some methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call new method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the application context
		appContext.close();
		
	}

}

/* SAMPLE OUTPUT
 
	>> TennisCoach class: inside the default constructor TennisCoach()
	Your Tennis workout: Practice your backhand volley
	Tennis coach fortune says: Beware of the wolf in sheep's clothing
	
*/

/* SECOND SAMPLE OUTPUT
	 
	>> TennisCoach class: inside the default constructor TennisCoach()
	Your Tennis workout: Practice your backhand volley
	Tennis coach fortune says: The Journey is the reward

*/