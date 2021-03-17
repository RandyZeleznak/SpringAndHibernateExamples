package com.zsquared.springdemo;

public class CricketCoach implements Coach {
	
	//define private field for the dependency
		private FortuneService fortuneService;
		
		private String emailAddress;
		private String team;
		
		public CricketCoach() {
			System.out.println("CricketCoach no arg constructor invoked");
		}
		
		
		
		
		public String getEmailAddress() {
			System.out.println("CricketCoach setemailAddress");
			return emailAddress;
		}


		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}


		public String getTeam() {
			return team;
		}


		public void setTeam(String team) {
			System.out.println("CricketCoach setTeam");
			this.team = team;
		}


	
	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach setFortuneService");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
