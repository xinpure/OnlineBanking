package com.banking.dao;

import com.banking.domain.CheckingTrans;
import com.banking.domain.CreditCardTrans;
import com.banking.domain.SavingTrans;

public interface TransDao {	
	/**
	 * paid by credit card
	 */	
	public String paidbyCreditCard(int userID, int CVN, String expireDate);
	
	/**
	 * withdraw money
	 */	
	public String withdrawMoney(int userID, String accountType, double amount);
	
	/**
	 * transfer money
	 */	
	public String transferMoney(int userID, String method, double amount);
	
	/**
	 * credit card transaction
	 */	
	public boolean transCreditCard(CreditCardTrans cct);
	
	/**
	 * saving transaction
	 */	
	public boolean transSaving(SavingTrans st);
	
	/**
	 * checking transaction
	 */	
	public boolean transChecking(CheckingTrans ct);
}
