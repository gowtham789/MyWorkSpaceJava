package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao1.AccountDAO;


public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			//add a boolean flag to simulate exceptions
			
			boolean tripWire = true;
			
			theAccounts =  theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e) {
			System.out.println("\n\n Main Program... caught exception :"  +e);
		}		
		//display the accounts
		
		System.out.println("\n\n Main Program : AfterThrowingDemoApp");
		System.out.println("-----------");
		
		System.out.println("The Accounts: " + theAccounts);
		
		// close the context
		context.close();
	}

}










