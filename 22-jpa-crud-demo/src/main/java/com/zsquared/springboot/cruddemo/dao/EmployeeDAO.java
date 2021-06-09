package com.zsquared.springboot.cruddemo.dao;

import java.util.List;

import com.zsquared.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findbyId(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	

}
