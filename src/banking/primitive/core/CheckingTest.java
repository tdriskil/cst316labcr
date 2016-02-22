/*
  File:	CheckingTest.java
  Author: Tyler Driskill, tdriskil
  Date:	02/21/16
  
  Description: File containing tests for Checking.java
*/

package banking.primitive.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
  Class: CheckingTest

  Description: JUnit Test class for Checking class
*/
public class CheckingTest {

	private static Checking testAccount = null;
	
	@Before
	public void setUp() throws Exception {
		testAccount = new Checking("CheckingTest", 100.0f);
	}

	/**
	  Method: overdrawnTest()
	  Inputs: N/A
	  Returns: N/A
	​
	  Description: Tests the overdraw functionality of the checking class
	*/
	@Test
	public void overdrawnTest() {
		assertEquals(testAccount.getState(), Account.State.OPEN);
		assertTrue(testAccount.withdraw(200.0f));
		assertEquals(testAccount.getBalance(), -100.0f, 0.1f);
		assertEquals(testAccount.getState(), Account.State.OVERDRAWN);
		assertTrue(testAccount.withdraw(200.0f));
		assertEquals(testAccount.getBalance(), -300.0f, 0.1f);
		assertEquals(testAccount.getState(), Account.State.OVERDRAWN);
		assertFalse(testAccount.withdraw(200.0f));
		assertEquals(testAccount.getBalance(), -300.0f, 0.1f);
		assertEquals(testAccount.getState(), Account.State.OVERDRAWN);
	}

}
