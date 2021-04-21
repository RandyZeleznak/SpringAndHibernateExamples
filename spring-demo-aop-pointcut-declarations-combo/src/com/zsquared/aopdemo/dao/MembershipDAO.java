package com.zsquared.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " : DOing stuff in Membership addAccount");
	}
	
	public void checkAccount() {
		System.out.println(getClass() + " : Checking account in Membership Account");
	}

}
