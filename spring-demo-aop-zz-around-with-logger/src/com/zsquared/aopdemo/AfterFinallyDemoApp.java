package com.zsquared.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zsquared.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = null;
		
		//calll method to find accounts
		try {
			boolean tripwire = false;
		accounts = accountDAO.findAccounts(tripwire);
		} catch(Exception exc) {
			System.out.println("\n Main program threw and exception" +exc);
		}
		
		// display accounts
		System.out.println("\n\nMain Programm : After THrowing Demo");
		System.out.println("------------------------");
		System.out.println(accounts);
		System.out.println("\n");
		
		// close the context
		context.close();
		
	}

}
