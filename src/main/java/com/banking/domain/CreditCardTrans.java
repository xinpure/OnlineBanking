package com.banking.domain;

import java.util.Date;

public class CreditCardTrans extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cardTransID;
	private int cardID;

	public CreditCardTrans() {

	}

	public CreditCardTrans(int cardTransID, int cardID, int userID, int transID, String detail, Date transDate, 
			double amount, double availableAmount) {
		super(transID, userID, detail, transDate, amount, availableAmount);
		this.cardTransID = cardTransID;
		this.cardID = cardID;
	}

	public int getCardTransID() {
		return cardTransID;
	}

	public void setCardTransID(int cardTransID) {
		this.cardTransID = cardTransID;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

}
