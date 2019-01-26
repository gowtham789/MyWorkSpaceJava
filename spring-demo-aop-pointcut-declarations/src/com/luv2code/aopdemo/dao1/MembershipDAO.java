package com.luv2code.aopdemo.dao1;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public Boolean addAccount() {
		
		System.out.println(getClass() + ":Doing Stuff Membership DAO");
		
		return true;
	}

}
