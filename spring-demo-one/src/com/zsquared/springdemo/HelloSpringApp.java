package com.zsquared.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// Load Spring Configuration File
		ClassPathXmlApplicationContext context = 
					new ClassPathXmlApplicationContext("applicationContext.xml");
		
		context.refresh();
		
		// Retrieve the bean from the Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Call methods on the Bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		//Close the conext
		context.close();

	}

}
