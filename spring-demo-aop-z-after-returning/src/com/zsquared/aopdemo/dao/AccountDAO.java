package com.zsquared.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zsquared.aopdemo.Account;

@Component	
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		//create sample accounts
		Account temp1 = new Account("john","silver");
		Account temp2 = new Account("Sara", "gold");
		Account temp3 = new Account("Lucas","Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() +  ": Doing my DB work: Adding Account");
	}
	
	public boolean didWork() {
		System.out.println(getClass() +  ": Doing  work: didWork()?");
		return false;
	}

	public String getName() {
		System.out.println(getClass() +  ": Doing  work: getName()?");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +  ": Doing  work: setName()?");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +  ": Doing  work: getServiceCode()?");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +  ": Doing  work: setServiceCode()?");
		this.serviceCode = serviceCode;
	}
	
	

}
