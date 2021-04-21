package com.zsquared.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zsquared.aopdemo.dao.AccountDAO;
import com.zsquared.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		Account myAccount = new Account();
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		accountDAO.addAccount(myAccount, true);
		accountDAO.didWork();
		
		accountDAO.setName("fubar");
		accountDAO.setServiceCode("Gold");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		membershipDAO.addAccount();
		membershipDAO.checkAccount();
		
		// close the context
		context.close();
		
	}

}
