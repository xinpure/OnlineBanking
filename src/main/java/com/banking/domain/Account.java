package com.banking.domain;

import java.util.Date;

public class Account implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;	
  // Fields

  private int accountID;
  private int userID;
  private Date openDate;
  private String status = "available";

  // Constructors

  /** default constructor */
  public Account() {
  }

  /** full constructor */
  public Account(int accountID, int userID, String status) {
    this.accountID = accountID;
    this.userID = userID;
    this.openDate = new Date();
  }

  // Property accessors

  public int getAccountID() {
    return accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getOpenDate() {
    return openDate;
  }

  public void setOpenDate(Date openDate) {
    this.openDate = openDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Account)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Account a = (Account) obj;
    return this.accountID == a.accountID;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + accountID;
    return result;
  }
  
}