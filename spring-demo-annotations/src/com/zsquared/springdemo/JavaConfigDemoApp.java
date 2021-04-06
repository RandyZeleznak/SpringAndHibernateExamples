package com.zsquared.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {


		// Read Spring Config Java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		//theCoach = context.getBean("baseballCoach", Coach.class);
		//System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();

	}

}
