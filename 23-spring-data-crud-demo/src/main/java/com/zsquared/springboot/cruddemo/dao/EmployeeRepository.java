package com.zsquared.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zsquared.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
