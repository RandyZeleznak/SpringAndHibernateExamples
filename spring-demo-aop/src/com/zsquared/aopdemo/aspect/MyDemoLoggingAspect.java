package com.zsquared.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is were we add all related advices for logging
	@Before("execution(* com.zsquared.aopdemo.dao.*.*( ..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n------->>>>> Executing @Before advice on addAccount()");
	}

}
