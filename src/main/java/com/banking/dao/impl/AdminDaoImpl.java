package com.banking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.banking.dao.AdminDao;
import com.banking.domain.Checking;
import com.banking.domain.CreditCard;
import com.banking.domain.Saving;
import com.banking.domain.User;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

public class AdminDaoImpl implements AdminDao{
	
	private HibernateBaseDao helper = new HibernateBaseDao();
	
	/**
	 * login
	 */	
	public boolean doLogin(String username, String password)
	{
		if(username.equals("admin") && password.equals("admin"))
			return true;
		else
			return false;
	}
	
	/**
	 * add user
	 */	
	public boolean addUser(User user)
	{
		if(helper.save(user))
			return true;
		else
			return false;			
	}
	
	/**
	 * view user
	 */	
	public List<User> viewUser()
	{
		Session session = HibernateSessionFactory.getSession();
		String hql="from User";
		Query query = session.createQuery(hql);
		List<User> listUser = query.list();
		session.close();
		if(listUser.size() != 0)
			return listUser;	
		else
			return null;
	}
	
	/**
	 * edit user
	 */	
	public boolean editUser(User user)
	{
		if(helper.update(user))
			return true;
		else
			return false;				
	}
	
	/**
	 * delete user
	 */	
	public boolean deleteUser(int userID)
	{
		if(helper.search(User.class, userID) != null)
		{
			if(helper.delete(helper.search(User.class, userID)))
				return true;
			else
				return false;				
		}
		else
			return false;				
	}
	
	/**
	 * open account
	 */	
	public boolean openChecking(Checking account)
	{
		if(helper.save(account))
			return true;
		else
			return false;					
	}
	
	public boolean openSaving(Saving account)
	{
		if(helper.save(account))
			return true;
		else
			return false;	
	}
	
	public boolean openCreditCard(CreditCard account)
	{
		if(helper.save(account))
			return true;
		else
			return false;		
	}
	
	/**
	 * freeze account
	 */	
	public boolean freezeChecking(int accountID)
	{
		if(helper.search(Checking.class, accountID) != null)
		{
			Checking checking = (Checking)helper.search(Checking.class, accountID);
			checking.setStatus("freeze");
			if(helper.update(checking))
				return true;
			else
				return false;				
		}
		else
			return false;				
	}
	
	public boolean freezeSaving(int accountID)
	{
		if(helper.search(Saving.class, accountID) != null)
		{
			Saving saving = (Saving)helper.search(Saving.class, accountID);
			saving.setStatus("freeze");
			if(helper.update(saving))
				return true;
			else
				return false;				
		}
		else
			return false;					
	}
	
	public boolean freezeCreditCard(int accountID)
	{
		if(helper.search(CreditCard.class, accountID) != null)
		{
			CreditCard creditCard = (CreditCard)helper.search(CreditCard.class, accountID);
			creditCard.setStatus("freeze");
			if(helper.update(creditCard))
				return true;
			else
				return false;				
		}
		else
			return false;		
	}
	
	/**
	 * unfreeze account
	 */	
	public boolean unfreezeChecking(int accountID)
	{
		if(helper.search(Checking.class, accountID) != null)
		{
			Checking checking = (Checking)helper.search(Checking.class, accountID);
			checking.setStatus("available");
			if(helper.update(checking))
				return true;
			else
				return false;				
		}
		else
			return false;				
	}
	
	public boolean unfreezeSaving(int accountID)
	{
		if(helper.search(Saving.class, accountID) != null)
		{
			Saving saving = (Saving)helper.search(Saving.class, accountID);
			saving.setStatus("available");
			if(helper.update(saving))
				return true;
			else
				return false;				
		}
		else
			return false;					
	}
	
	public boolean unfreezeCreditCard(int accountID)
	{
		if(helper.search(CreditCard.class, accountID) != null)
		{
			CreditCard creditCard = (CreditCard)helper.search(CreditCard.class, accountID);
			creditCard.setStatus("available");
			if(helper.update(creditCard))
				return true;
			else
				return false;				
		}
		else
			return false;		
	}
}
