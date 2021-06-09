package com.zsquared.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zsquared.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create query
		Query theQuery = entityManager.createQuery("from Employee");
		
		// execute query and get resultlist
		List<Employee> employees = theQuery.getResultList();
		
		
		// return the results
		return employees;
	}

	@Override
	public Employee findbyId(int theId) {
		// get employee 
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update the id from db  so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
