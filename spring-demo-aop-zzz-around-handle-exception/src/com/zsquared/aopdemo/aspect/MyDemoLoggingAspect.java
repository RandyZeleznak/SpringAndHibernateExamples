package com.zsquared.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* com.zsquared.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n ----> Executing @Around on method : " +method);	
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			// rethrow exception
			throw e;
		}
		
		//get end timestamp
		long end  = System.currentTimeMillis();
		
		// compute duration and display
		long duration = end - begin;
		myLogger.info("\n ------> Duration : " +duration/1000.0 + " seconds");
		return null;
	}
	
	
	
	
	@After("execution(* com.zsquared.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAcountAdvice(JoinPoint theJoinPoint) {
		// print out method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ----> Executing @After(finally) on method : " +method);	
	}
	
	
	
	@AfterThrowing(
			pointcut="execution(* com.zsquared.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
				JoinPoint theJoinPoint, Throwable theExc) {
		// print out method advising on
				String method = theJoinPoint.getSignature().toShortString();
				myLogger.info("\n ----> Executing @AfterThrowing on method : " +method);
				
				// print out method advising on
				myLogger.info("\n ----> Executing @AfterThrowinging on method : " +theExc);
	}
	
	// Add AfterReturning advice on findAccounts method
	@AfterReturning(
				pointcut="execution(* com.zsquared.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ----> Executing @AfterReturning on method : " +method);
		
		
		// print out results of method call
		myLogger.info("\n ----> result is : " +result);
		
		// post process data 
		
		//convert account names to upper case
		convertNamesToUpperCase(result);
		myLogger.info("\n ----> result is : " +result);
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
		myLogger.info("\n------->>>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method : "+methodSignature);
		
		// display the method arguments
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the arguements
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account account = (Account) tempArg;
				
				myLogger.info("Account name : " +account.getName());
				myLogger.info("Account level :" +account.getLevel());
				
			}
		}
	}

	
	
	
}
