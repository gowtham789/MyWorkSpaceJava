package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	//Declare the Pointcut
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.*(..))")
	public void forDaopackage() {}
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.get*(..))")
	public void getter() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao1.*.set*(..))")
	public void setter() {}
	
	//create point: include package ...exclude getter/setter
	@Pointcut("forDaopackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
