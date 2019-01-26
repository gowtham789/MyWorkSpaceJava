package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//Declare the Pointcut
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.*(..))")
	private void forDaopackage() {}
	

	@Before("forDaopackage()") 
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method()");
		
	}
	
	@Before("forDaopackage()") 
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API analytics");
		
	}
}










