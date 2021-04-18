package com.zsquared.springdemo.dao;

import java.util.List;

import com.zsquared.springdemo.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	

}
