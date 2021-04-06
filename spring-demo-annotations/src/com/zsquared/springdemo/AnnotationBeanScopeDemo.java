package com.zsquared.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//Check if same memory location
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Point to same location? " +result);
		System.out.println("theCoach memory location = " + theCoach);
		System.out.println("alphaCoach memory location = " + alphaCoach);
		
		
		context.close();

	}

}
