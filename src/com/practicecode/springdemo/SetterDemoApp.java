package com.practicecode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve Bean from Srping location
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on Beans
		System.out.println("This is from SetterDemoApp");
		System.out.println(theCoach.getDailyFortune());
		System.out.println("This is after Daily Fortune");
		
		System.out.println(theCoach.getDailyWorkout());
		
		//close the content
		context.close();
		
		
	}
}
