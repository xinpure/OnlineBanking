package com.banking.domain;

import java.util.Date;

public class Checking extends Account{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;	
  // Fields

  private int checkingID;
  private double balance;

  // Constructors

  /** default constructor */
  public Checking() {
  }

  /** full constructor */
  public Checking(int accountID, int userID, Date openDate, String status, int checkingID, double balance) {
    super(accountID, userID, openDate, status);
    this.checkingID = checkingID;
    this.balance = balance;
  }

  // Property accessors

  public int getCheckingID() {
    return checkingID;
  }

  public void setCheckingID(int checkingID) {
    this.checkingID = checkingID;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }	
  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Checking)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Checking c = (Checking) obj;
    return this.checkingID == c.checkingID;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + checkingID;
    return result;
  }
}
