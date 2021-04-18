package com.zsquared.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsquared.springdemo.entity.Customer;
import com.zsquared.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customerd service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
		public String listCustomers(Model theModel) {

		// get the customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model to bind Customer
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// save the customer
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
}
