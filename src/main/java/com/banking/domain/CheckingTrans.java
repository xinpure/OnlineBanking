package com.banking.domain;

import java.util.Date;

public class CheckingTrans extends Transaction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int checkingTransID;
	private int checkingID;

	public CheckingTrans() {

	}

	public CheckingTrans(int checkingTransID, int checkingID, int userID, int transID, String detail, 
			Date transDate, double amount, double availableAmount) {
		super(transID, userID, detail, amount, availableAmount);
		this.checkingTransID = checkingTransID;
		this.checkingID = checkingID;
	}

	public int getCheckingTransID() {
		return checkingTransID;
	}

	public void setCheckingTransID(int checkingTransID) {
		this.checkingTransID = checkingTransID;
	}

	public int getCheckingID() {
		return checkingID;
	}

	public void setCheckingID(int checkingID) {
		this.checkingID = checkingID;
	}

}
