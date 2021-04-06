package com.zsquared.springdemo;


import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	private String[] data = {
			"Beware of the darkness",
			"Perseverance is rewarded",
			"It's the journey, not the destination"
	};
	
	//create a random number
	private Random myRandom = new Random();
	
	

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
