package com.banking.domain;

import java.util.Date;

public class Transaction implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int transID;
    private int userID;
    private String detail;
    private Date transDate;
    private double availableAmount;
    private double amount;
    
    public Transaction() {

    }
    
    public Transaction(int transID, int userID, String detail, Date transDate, double amount, double availableAmount) {
        this.transID = transID;
        this.userID = userID;
        this.detail = detail;
        this.transDate = transDate;
        this.amount = amount;
        this.availableAmount = availableAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
