package com.banking.domain;

import java.util.Date;

public class SavingTrans extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int savingTransID;
	private int savingID;
	
	public SavingTrans() {

	}

	public SavingTrans(int savingTransID, int savingID, int userID, int transID, String detail, Date transDate, 
			double amount, double availableAmount) {
		super(transID, userID, detail, amount, availableAmount);
		this.savingTransID = savingTransID;
		this.savingID = savingID;
	}

	public int getSavingTransID() {
		return savingTransID;
	}

	public void setSavingTransID(int savingTransID) {
		this.savingTransID = savingTransID;
	}

	public int getSavingID() {
		return savingID;
	}

	public void setSavingID(int savingID) {
		this.savingID = savingID;
	}

}
