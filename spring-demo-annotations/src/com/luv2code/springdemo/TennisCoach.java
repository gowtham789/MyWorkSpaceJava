package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//@Component("thatSillyCoach") //explicit bean id 
@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService; 
	
	//define a default constructor

	public TennisCoach() {
		System.out.println(">>Tennis Coach : inside default constructor");
	}
	
	//define a setter method
/*	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">>Tennis Coach : inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}
	*/
	//define a custom method
		@Autowired
		@Qualifier("randomFortuneService")
		public void doSomeCrazyStuff(FortuneService fortuneService) {
			System.out.println(">>Tennis Coach : inside doSomeCrazyStuff() method");
			this.fortuneService = fortuneService;
		}
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	 }*/
	
	

	@Override
	public String getDailyWorkout() {		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">> TennisCoach : inside of doMyStartupStuff()");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(">> TennisCoach : inside of doMyCleanupStuff()");
	}

}
