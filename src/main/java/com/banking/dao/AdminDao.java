package com.banking.dao;

import java.util.List;

import com.banking.domain.Checking;
import com.banking.domain.CreditCard;
import com.banking.domain.Saving;
import com.banking.domain.User;

public interface AdminDao {
	/**
	 * login
	 */	
	public boolean doLogin(String username, String password);
	
	/**
	 * add user
	 */	
	public boolean addUser(User user);

	/**
	 * view user
	 */	
	public List<User> viewUser();
	
	/**
	 * edit user
	 */	
	public boolean editUser(int userID, User user);
	
	/**
	 * delete user
	 */	
	public boolean deleteUser(int userID);
	
	/**
	 * open account
	 */	
	public boolean openChecking(Checking account);
	public boolean openSaving(Saving account);
	public boolean openCreditCard(CreditCard account);
	
	/**
	 * freeze account
	 */	
	public boolean freezeChecking(int accountID);
	public boolean freezeSaving(int accountID);
	public boolean freezeCreditCard(int accountID);	
	
	/**
	 * unfreeze account
	 */	
	public boolean unfreezeChecking(int accountID);
	public boolean unfreezeSaving(int accountID);
	public boolean unfreezeCreditCard(int accountID);	
}
