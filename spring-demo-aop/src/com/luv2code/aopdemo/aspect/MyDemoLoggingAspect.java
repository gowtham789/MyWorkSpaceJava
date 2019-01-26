package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	//@Before("execution(public void com.luv2code.aopdemo.dao1.AccountDAO.addAccount())")
	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(Boolean add*())")   //return type boolean with method name starting with "add"
	//@Before("execution(* add*())") //return type any with method name starting with "add" and no parameter
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))") //return type any with method name starting with "add" and one parameter
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")  //match arg with account object and followed by any no of args
	//@Before("execution(* add*(..))")  //Match any parameters starting with "add" method name
	@Before("execution(* com.luv2code.aopdemo.dao1.*.*(com.luv2code.aopdemo.Account))")  //match with package "com.luv2code.aopdemo.dao1" and with account parameter 
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		//System.out.println("\n=====>>> Executing @Before advice on method()");
		
	}
}










