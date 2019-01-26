package com.luv2code.aopdemo.dao1;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void doWork(Account account) {
		
		System.out.println(getClass() + ": doWork()");
		
	}
}
