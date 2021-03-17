package com.practicecode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		
		// LOad the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		// retrieve the bean from the spring container
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n Pointing to the same object " + result);
		
		System.out.println("\nMemory location of the Coache = " +theCoach);
		
		System.out.println("\nMemory location of alpha Coache = " +alphaCoach + "\n");
		
		

	}

}
