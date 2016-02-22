/*
  File:	NewAccountFactoryt.java
  Author:Tyler Driskill, tdriskil 
  Date:	02/21/16
  
  Description: Factory to produce accounts of either type.
*/

package banking.primitive.core;

/**
Class: NewAccountFactory

Description: Factory class with static a static method to produce accounts of either type.
*/
public class NewAccountFactory {
	
	/**
	  Method: createAccount
	  Inputs: String type   : Type of account, "Savings" or "Checking"
	          String name   : Specific Name of account
	          float balance : Starting Balance of account
	  Returns: Account      : the created account
	​
	  Description: Creates and returns account based on the input variables
	*/
	public static Account createAccount(String type, String name, float balance)
		throws IllegalArgumentException {
		
		Account acc;
		if ("Checking".equals(type)) {
			acc = new Checking(name, balance);

		} else if ("Savings".equals(type)) {
			acc = new Savings(name, balance);

		} else {
			throw new IllegalArgumentException("Bad account type:" + type);
		}
		return acc;
	}

}
