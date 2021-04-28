package com.zsquared.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zsquared.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	
	private static Logger myLogger = 
				Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\n Main program - AroundHandleExceptionDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripwire = true;
		
		String data = theFortuneService.getFortune(tripwire);
		
		myLogger.info("\nMy fortune is " +data);
		myLogger.info("DONE!");
		
		// close the context
		context.close();
		
	}

}
