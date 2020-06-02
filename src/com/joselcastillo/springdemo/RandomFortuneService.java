package com.joselcastillo.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService_Interface {

	// Create an array of fortune strings
	private String[] fortunesData = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The Journey is the reward"
			};
	
	// Create a randum number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		// Pick a random fortune from the array of fortune strings
		int fortunesIndex = myRandom.nextInt(fortunesData.length); // index based on size of array
		
		
		String theFortune = fortunesData[fortunesIndex]; // Grab a fortune from the array
		
		return theFortune;
	}

}
