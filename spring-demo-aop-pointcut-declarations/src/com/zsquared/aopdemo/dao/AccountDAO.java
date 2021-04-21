package com.zsquared.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.zsquared.aopdemo.Account;

@Component	
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() +  ": Doing my DB work: Adding Account");
	}
	
	public boolean didWork() {
		System.out.println(getClass() +  ": Doing  work: didWork()?");
		return false;
	}

}
