package com.zsquared.springdemo;

public class TrackCoach implements Coach {
	
	//define private field for the dependency
		private FortuneService fortuneService;
		
		
	public TrackCoach() {}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It : " + fortuneService.getFortune()	;
	}

	
	// init method
	public void doStartUpStuff() {
		System.out.println("TrackCoach: Startup ");
	}
	
	
	//destroy method
	public void doCleanUpStuff() {
		System.out.println("TrackCoach: Cleanup ");
	}
	
	
	
}
