package com.banking.dao;

import java.util.List;

import com.banking.domain.CheckingTrans;
import com.banking.domain.CreditCardTrans;
import com.banking.domain.SavingTrans;

public interface UserDao {
	/**
	 * login
	 */	
	public boolean doLogin(String username, String password);

	/**
	 * view account
	 */	
	public List<CheckingTrans> viewCheckingTrans(int userID);
	public List<SavingTrans> viewSavingTrans(int userID);
	public List<CreditCardTrans> viewCreditCardTrans(int userID);
	
	/**
	 * change password
	 */	
	public boolean changePassword(int userID, String password);
	
	/**
	 * forget password
	 */	
	public String forgetPassword(String username, String email, String ssn);
}
