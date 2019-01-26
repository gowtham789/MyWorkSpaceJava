package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao1.AccountDAO;
import com.luv2code.aopdemo.dao1.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		// get membership bean from spring container
				MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
				
				
		// call the business method
		theAccountDAO.addAccount(new Account()); 
		theAccountDAO.doWork(new Account());
		
		//call the membership method
		theMembershipDAO.addAccount();

		/*// do it again!
		System.out.println("\nlet's call it again!\n");
		
		// call the business method again
		theAccountDAO.addAccount();*/
				 
		// close the context
		context.close();
	}

}










