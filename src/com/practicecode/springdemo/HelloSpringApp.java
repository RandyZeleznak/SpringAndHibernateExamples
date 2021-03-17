 package com.practicecode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from spring container
		
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		//close the container
		context.close();

	}

}
