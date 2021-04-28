package com.zsquared.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.zsquared.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.zsquared.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.zsquared.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("---> @Before : Calling method " +theMethod);
	
	
		// display the arguements to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through and display
		for(Object tempArg : args) {
			myLogger.info("----> arguement : " +tempArg);
		}
	}
	
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// displayAfterReturning method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("---> @AfterReturning : Calling method " +theMethod);
		
		//display data returned
		myLogger.info("----> result : " +theResult);
		
	}
	
	
	
	
	
	
	
	
	
	
}
