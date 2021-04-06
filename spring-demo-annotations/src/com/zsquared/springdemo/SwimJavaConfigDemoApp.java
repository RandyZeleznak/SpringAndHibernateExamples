package com.zsquared.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {


		// Read Spring Config Java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Email = " +theCoach.getEmail());
		System.out.println("Team = " +theCoach.getTeam());
		
		
		//theCoach = context.getBean("baseballCoach", Coach.class);
		//System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();

	}

}
