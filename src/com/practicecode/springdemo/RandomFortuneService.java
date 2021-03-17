package com.practicecode.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	//Create array of responses
	private String[] randomResponses = 
		{
		"Today is a sunny day",
		"Rain makes things grow",
		"Tomorrow is another day"
		};
	
	private Random myRandomResponse = new Random();

	@Override
	public String getFortune() {
		// Pick a random string to relay
		int index = myRandomResponse.nextInt(randomResponses.length);
		
		String theFortune = randomResponses[index];
				
		return theFortune;
	}
	

}
