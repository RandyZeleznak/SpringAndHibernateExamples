package com.zsquared.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zsquared.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	
	
	// this is were we add all related advices for logging
	@Before("com.zsquared.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n------->>>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : "+methodSignature);
		
		// display the method arguments
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the arguements
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account account = (Account) tempArg;
				
				System.out.println("Account name : " +account.getName());
				System.out.println("Account level :" +account.getLevel());
				
			}
		}
	}

	
	
	
}
