package com.zsquared.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// Controller method to show inital html page
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// Controller method to process html form page
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// Controller to to read form data
	// and add data to the model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read request parameter from html form
		String theName = request.getParameter("studentName");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo " +theName;
		System.out.println(result);
		
		// add message to the model
		model.addAttribute("message", result);
		
		
			return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {
		
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey, what's up  " +theName;
		System.out.println(result);
		
		// add message to the model
		model.addAttribute("message", result);
		
		
			return "helloworld";
	}
	
	
}
