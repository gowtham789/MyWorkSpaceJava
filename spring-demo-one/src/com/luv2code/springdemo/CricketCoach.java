package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//add new fields for emailaddress and team
	
	private String emailAddress;
	private String team;
	
	//create a no-arg contructor
	
	public CricketCoach()
	{
		System.out.println("Cricket Coach: inside no-arg constructor");
	}
	
	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method : setFortuneService ");
		this.fortuneService = fortuneService;
	}  
	
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach: inside setter method : setEmailAddress ");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach: inside setter method : setTeam ");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15min";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
