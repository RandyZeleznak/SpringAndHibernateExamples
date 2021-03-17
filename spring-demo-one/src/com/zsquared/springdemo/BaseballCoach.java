package com.zsquared.springdemo;

public class BaseballCoach implements Coach {
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	//definition of constructor for Dependency Injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "SPEND 30 minutres batting";
	}

	@Override
	public String getDailyFortune() {
		// use fortuneService  to get  fortune
		return fortuneService.getFortune();
	}

}
