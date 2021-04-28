package com.zsquared.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zsquared.aopdemo.service.TrafficFortuneService;

public class AroundWIthLoggerDemoApp {
	
	
	private static Logger myLogger = 
				Logger.getLogger(AroundWIthLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\n Main program - AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is " +data);
		myLogger.info("DONE!");
		
		// close the context
		context.close();
		
	}

}
