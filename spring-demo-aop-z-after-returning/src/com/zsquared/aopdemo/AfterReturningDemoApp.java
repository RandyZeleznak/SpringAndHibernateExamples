package com.zsquared.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zsquared.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//calll method to find accounts
		List<Account> accounts = accountDAO.findAccounts();
		
		// display accounts
		System.out.println("\n\nMain OProgramm : After Return Demo");
		System.out.println("------------------------");
		System.out.println(accounts);
		System.out.println("\n");
		
		// close the context
		context.close();
		
	}

}
