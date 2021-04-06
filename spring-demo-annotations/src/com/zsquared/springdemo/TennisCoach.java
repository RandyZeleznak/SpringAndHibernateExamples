package com.zsquared.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside Tennis default constructor");
	}
	
	// init method
	@PostConstruct
	public void doStartUp() {
		System.out.println(">>Tennis Coach : START UP");
	}
	
	
	// destroy method
	@PreDestroy
	public void doCleanUp() {
		System.out.println(">>Tennis Coach : CLEAN UP");
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("Inside Tennis setFortuneService()");
		fortuneService = theFortuneService;
	}
	*/
	/*
	@Autowired
	public void genericMethod(FortuneService theFortuneService) {
		System.out.println("Inside Tennis genericMethod()");
		fortuneService = theFortuneService;
	}
	*/
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
