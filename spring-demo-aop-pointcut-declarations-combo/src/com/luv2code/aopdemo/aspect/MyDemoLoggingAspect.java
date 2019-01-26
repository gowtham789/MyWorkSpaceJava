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
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.get*(..))")
	private void getter() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.set*(..))")
	private void setter() {}
	
	//create point: include package ...exclude getter/setter
	@Pointcut("forDaopackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}

	@Before("forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method()");
		
	}
	
	@Before("forDaoPackageNoGetterSetter()") 
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API analytics");
		
	}
}










