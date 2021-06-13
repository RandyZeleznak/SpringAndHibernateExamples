package com.zsquared.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsquared.springboot.thymeleafdemo.entity.Employee;
import com.zsquared.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
		private EmployeeService employeeService;
		
		public EmployeeController(EmployeeService theEmployeeService) {
			employeeService = theEmployeeService;
		}

		
		
		// add mapping for "/list-employees"
		
		@GetMapping("/list")
		public String listEmployees(Model theModel) {
			
			List<Employee> theEmployees = employeeService.findAll();
			theModel.addAttribute("employees", theEmployees);
			
			return "employees/list-employees";
		}
		
		// mapping for showFormForAdd
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			//create model attribute to bind to form data
			Employee theEmployee = new Employee();
			theModel.addAttribute("employee", theEmployee);
			return "employees/employee-form";
			
		}
		
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
			
			// save Employee
			employeeService.save(theEmployee);
			
			// use redirect to prevent duplicate submissions
			return "redirect:/employees/list";
		}
		
		
		
		
		
		
		
		
		
		
	
	
	
		

}
