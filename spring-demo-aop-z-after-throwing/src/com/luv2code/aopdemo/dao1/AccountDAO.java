package com.luv2code.aopdemo.dao1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void doWork(Account account) {
		
		System.out.println(getClass() + ": doWork()");
		
	}

	public String getName() {
		System.out.println(getClass() + ":in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ":in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ":in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ":in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	//add a new method : findAccounts()
	public List<Account> findAccounts(boolean tripWire) {
		
		//for academix purpose ....simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for u !!!");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		//create sample accounts
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Ram","Platinum");
		Account temp3 = new Account("Lisa","Bronze");
		
		//add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}		
}
