/*
  File:	Account.java
  Author: KGary
  Date:	02/15/16
  
  Description: File containing Abstract Account class declaration.
*/
package banking.primitive.core;

/**
Class: Account

Description: An abstract class that outlines the desired methods and instance variables
             for child classes to possess. 
*/
public abstract class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected enum State {
        OPEN, CLOSED, OVERDRAWN
    };

    protected float balance = 0.0F;
    protected String name;
    private State state;

    protected Account(String n) {
        name = n;
        state = State.OPEN;
    }

    protected Account(String n, float b) {
        this(n); 
        balance = b;
    }

    public final String getName() {
        return name;
    }

    public final float getBalance() {
        return balance;
    }

    /**
      Method: deposit
      Inputs: float amount : a deposit value and must be > 0
      Returns: boolean     : true if the deposit was successful, false if not 
                             due to amount or invalid state
  ​ 
      Description: Adds money to an account. May not be done if the account is CLOSED.
    */
    public abstract boolean deposit(float amount);

    /**
      Method: withdraw
      Inputs: float amount : a withdrawal value and must be > 0
      Returns: boolean     : true if the deposit was successful, false if not due to 
                             amount or invalid state.
  ​
      Description: Takes money out of an account. If the balance falls below 0 then the
                   account is moved to an OVERDRAWN state.
    */
    public abstract boolean withdraw(float amount);

    public abstract String getType();

    protected final State getState() {
        return state;
    }

    protected final void setState(State s) {
        state = s;
    }

    /**
    Method: toString
    Inputs: N/A
    Returns: String : the formatted string
​
    Description: Returns formated string containing account name, balance, and state.
  */
    public String toString() {
        return "Account " + name + " has $" + balance + "and is " + getState()
                + "\n";
    }
}
