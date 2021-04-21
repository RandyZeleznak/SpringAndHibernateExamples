package com.zsquared.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	// Add AfterReturning advice on findAccounts method
	@AfterReturning(
				pointcut="execution(* com.zsquared.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out method advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ----> Executing @AfterReturning on method : " +method);
		
		
		// print out results of method call
		System.out.println("\n ----> result is : " +result);
		
		// post process data 
		
		//convert account names to upper case
		convertNamesToUpperCase(result);
		System.out.println("\n ----> result is : " +result);
	}
	
	
	
	private void convertNamesToUpperCase(List<Account> result) {
		// loop thru accounts
		for(Account tempAccount : result) {
		
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
			
		}
		
	}



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
