package com.zsquared.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions; 
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create Student Object
		Student theStudent = new Student();
		
		// Add Student to Model
		theModel.addAttribute("student", theStudent);
		
		//add countryOptions to Model
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}

}
