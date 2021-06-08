package com.zsquared.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class FunRestController {
	
	// inject properties for coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint of team info
	@GetMapping("/teaminfo")
	public String teamInfo() {
		return "Coach " +coachName+ " of the "+teamName;
	}
	
	// expose "/" endpoint that returns  Hello World
	@GetMapping	("/")
	public String sayHello() {
		return "Hello Randy: Time on server is " +LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run Forest Run!";
	}
	
	// expose a new endpoint for "fortune"
		@GetMapping("/fortune")
		public String getFortunet() {
			return "You've won $1,000,000!";
		}
	

}
