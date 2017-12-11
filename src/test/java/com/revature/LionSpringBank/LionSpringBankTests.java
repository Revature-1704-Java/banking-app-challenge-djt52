package com.revature.LionSpringBank;

import static org.junit.Assert.*;
import org.junit.Test;

public class LionSpringBankTests {
	
	@Test
	public final void CheckingInterestTest() {
		Checking check = new Checking("TestAcct");
		assertEquals("TestAcct",check.name);
		assertEquals(50,check.interest(50));
	}
	
	@Test
	public final void BankingInterestTest() {
		BankSystem sys = new BankSystem();
		sys.setInterest(1.06f);
		assertEquals(1.06,sys.getInterest());
	}
	
	@Test
	public final void SavingsInitialization() {
		Savings s = new Savings("TestAcc",1.06f);
		assertEquals("TestAcct",s.name);
		assertEquals(1.06,s.interest);
	}
}
