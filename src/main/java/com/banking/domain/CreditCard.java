package com.banking.domain;

import java.util.Date;

public class CreditCard extends Account{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;    
    // Fields

    private int cardID;
    private String expireDate = "1111";
    private int CVN = 222;
    private double balance;

    // Constructors

    /** default constructor */
    public CreditCard() {
    }

    /** full constructor */
    public CreditCard(int accountID, int userID,int cardID, double balance) {
        super(accountID, userID);
        this.cardID = cardID;
        this.balance = balance;
    }

    // Property accessors

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }   
    
    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }   
    
    public int getCVN() {
        return CVN;
    }

    public void setCVN(int CVN) {
        this.CVN = CVN;
    }
}
