/*
  File:	NewAccountFactoryTest.java
  Author:Tyler Driskill, tdriskil 
  Date:	02/21/16
  
  Description: Tests the NewAccountFactory class
*/
package banking.primitive.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class NewAccountFactoryTest {

	/**
	  Method: createAccountTest()
	  Inputs: N/A
	  Returns: N/A
	​
	  Description: Testing the createAccountTest() method in the NewAccountFactory class
	*/
	@Test
	public void createAccountTest() {
		try {
		    Account testAccount1 = NewAccountFactory.createAccount("Checking", "Test1", 100.0f);
		    assertEquals(testAccount1.getName(), "Test1");
		    assertEquals(testAccount1.getType(), "Checking");
		    assertEquals(testAccount1.getBalance(), 100.0f, 0.1f);
		} catch (IllegalArgumentException e) {
			fail("fail creating Checking account");
		}
		try {
			Account testAccount2 = NewAccountFactory.createAccount("Savings", "Test2", 1000.0f);
			assertEquals(testAccount2.getName(), "Test2");
			assertEquals(testAccount2.getType(), "Savings");
			assertEquals(testAccount2.getBalance(), 1000.0f, 0.1f);
		} catch (IllegalArgumentException e) {
			fail("fail creating Savings account");
		}
		boolean didThrowException = false;
		try {
			Account testAccount3 = NewAccountFactory.createAccount("Ravings", "Test3", 1000.0f);
			assertEquals(testAccount3.getName(), "Test3");
		} catch (IllegalArgumentException e) {
			didThrowException = true;
		}
		assertTrue(didThrowException);
	}

}
