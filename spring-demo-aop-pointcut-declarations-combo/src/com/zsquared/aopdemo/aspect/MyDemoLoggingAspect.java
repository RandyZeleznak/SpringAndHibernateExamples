package com.zsquared.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.*( ..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.get*( ..))")
	private void getter() {};
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.set*( ..))")
	private void setter() {};
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {};
	
	// this is were we add all related advices for logging
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n------->>>>> Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performStatistics() {
		System.out.println("\n ++++++===> perfroming Advice for performStatistics");
	}
}
