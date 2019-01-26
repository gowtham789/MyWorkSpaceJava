package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring java config class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		//	Coach theCoach = context.getBean("thatSillyCoach", Coach.class); //explicit bean id
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class); //default bean id
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
