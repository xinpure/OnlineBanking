package com.banking.domain;

import java.util.Date;

public class Saving extends Account{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;	
  // Fields

  private int savingID;
  private double balance;
  private double interestRate = 0.01;

  // Constructors

  /** default constructor */
  public Saving() {
  }

  /** full constructor */
  public Saving(int accountID, int userID, int savingID, double balance) {
    super(accountID, userID);
    this.savingID = savingID;
    this.balance = balance;
  }

  // Property accessors

  public int getSavingID() {
    return savingID;
  }

  public void setSavingID(int savingID) {
    this.savingID = savingID;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }	

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Saving)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Saving s = (Saving) obj;
    return this.savingID == s.savingID;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + savingID;
    return result;
  }
}
