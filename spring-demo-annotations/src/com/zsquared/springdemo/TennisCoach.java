package com.zsquared.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside Tennis default constructor");
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("Inside Tennis setFortuneService()");
		fortuneService = theFortuneService;
	}
	*/
	
	@Autowired
	public void genericMethod(FortuneService theFortuneService) {
		System.out.println("Inside Tennis genericMethod()");
		fortuneService = theFortuneService;
	}
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
