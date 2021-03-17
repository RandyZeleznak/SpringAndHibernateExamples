package com.zsquared.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your batting";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Nirvana";
	}

}
