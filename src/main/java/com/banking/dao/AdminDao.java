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
	public boolean editUser(User user);
	
	/**
	 * delete user
	 */	
	public boolean deleteUser(int userID);
	
	/**
	 * open account
	 */	
	public boolean openChecking(String username, Checking account);
	public boolean openSaving(String username, Saving account);
	public boolean openCreditCard(String username, CreditCard account);
	
	/**
	 * freeze account
	 */	
	public boolean freezeChecking(String username, String accountType);
	public boolean freezeSaving(String username, String accountType);
	public boolean freezeCreditCard(String username, String accountType);	
	
	/**
	 * unfreeze account
	 */	
	public boolean unfreezeChecking(String username, String accountType);
	public boolean unfreezeSaving(String username, String accountType);
	public boolean unfreezeCreditCard(String username, String accountType);	
}
