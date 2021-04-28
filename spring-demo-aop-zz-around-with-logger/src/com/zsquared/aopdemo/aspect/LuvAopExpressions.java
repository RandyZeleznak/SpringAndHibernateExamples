package com.zsquared.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.*( ..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.get*( ..))")
	public void getter() {};
	
	@Pointcut("execution(* com.zsquared.aopdemo.dao.*.set*( ..))")
	public void setter() {};
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {};

}
