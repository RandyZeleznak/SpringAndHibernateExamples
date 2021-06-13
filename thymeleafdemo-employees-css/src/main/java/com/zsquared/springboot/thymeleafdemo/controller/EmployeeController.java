package com.zsquared.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsquared.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void LoadData() {
		// create Employees
		Employee emp1 = new Employee(1,"James","Adams","jadams@usgov.com");
		Employee emp2 = new Employee(1,"George","Washington","gwashington@usgov.com");
		Employee emp3 = new Employee(1,"Thomas","Jefferson","tjefferson@usgov.com");
		
		// create list
		theEmployees = new ArrayList<>();
		
		// add to list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	}
		
		
		// add mapping for "/list-employees"
		
		@GetMapping("/list")
		public String listEmployees(Model theModel) {
			theModel.addAttribute("employees", theEmployees);
			
			return "list-employees";
		}
		
		
		
		
	
	
	
		

}
