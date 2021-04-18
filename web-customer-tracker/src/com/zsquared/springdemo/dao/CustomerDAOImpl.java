package com.zsquared.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zsquared.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		System.out.println("THe QUery " +theQuery);
		// exceute query and get result 
		List<Customer> customers = theQuery.getResultList();
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save customer to the database
		currentSession.save(customer);
	}

}
