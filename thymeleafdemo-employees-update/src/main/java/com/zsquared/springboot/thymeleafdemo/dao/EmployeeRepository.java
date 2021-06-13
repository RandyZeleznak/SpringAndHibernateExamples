package com.zsquared.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zsquared.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
