package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao1.AccountDAO;


public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(true);
		
		//display the accounts
		
		System.out.println("\n\n Main Program : AfterReturningDemoApp");
		System.out.println("-----------");
		
		System.out.println("The Accounts: " + theAccounts);
		
		// close the context
		context.close();
	}

}










