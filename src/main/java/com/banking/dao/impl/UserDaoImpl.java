package com.banking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.banking.domain.CheckingTrans;
import com.banking.domain.CreditCardTrans;
import com.banking.domain.SavingTrans;
import com.banking.domain.User;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

public class UserDaoImpl {
	
	private HibernateBaseDao helper = new HibernateBaseDao();
	
	/**
	 * login
	 */	
	public boolean doLogin(String username, String password)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql="select u from User as u where u.username=:username " +
		"and u.password=:password";
		Query query=session.createQuery(hql);	
		query.setString("username", username);
		query.setString("password", password);
		List<User> listUser = query.list();
		session.close();
		if(listUser.size() != 0)
			return true;
		else
			return false;
	}

	/**
	 * view account
	 */	
	public List<CheckingTrans> viewCheckingTrans(int userID)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select ct from CheckingTrans as ct where ct.userID=:userID";	
		Query query = session.createQuery(hql);
		query.setInteger("userID", userID);
		List<CheckingTrans> listCheckingTrans = query.list();
		session.close();
		if(listCheckingTrans.size() != 0)
			return listCheckingTrans;	
		else
			return null;		
	}
	
	public List<SavingTrans> viewSavingTrans(int userID)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select st from SavingTrans as st where st.userID=:userID";	
		Query query = session.createQuery(hql);
		query.setInteger("userID", userID);
		List<SavingTrans> listSavingTrans = query.list();
		session.close();
		if(listSavingTrans.size() != 0)
			return listSavingTrans;	
		else
			return null;			
	}
	
	public List<CreditCardTrans> viewCreditCardTrans(int userID)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select cct from CreditCardTrans as cct where cct.userID=:userID";	
		Query query = session.createQuery(hql);
		query.setInteger("userID", userID);
		List<CreditCardTrans> listCardTrans = query.list();
		session.close();
		if(listCardTrans.size() != 0)
			return listCardTrans;	
		else
			return null;		
	}
	
	/**
	 * change password
	 */	
	public boolean changePassword(int userID, String password)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select u from User as u where u.userID=:userID";	
		Query query = session.createQuery(hql);
		query.setInteger("userID", userID);
		List<User> listUser = query.list();
		session.close();	
		if(listUser.size() != 0)
		{
			listUser.get(0).setPassword(password);
			if(helper.update(listUser.get(0)))
				return true;
			else
				return false;			
		}	
		else
			return false;						
	}
	
	/**
	 * forget password
	 */	
	public String forgetPassword(String username, String email, String ssn)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select u from User as u where u.username=:username and u.email=:email and u.ssn=:ssn";	
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setString("email", email);
		query.setString("ssn", ssn);
		List<User> listUser = query.list();
		session.close();	
		if(listUser.size() != 0)
			return listUser.get(0).getPassword();		
		else
			return null;		
	}
	
	/**
	 * get userID
	 */	
	public int getUserID(String username, String password)
	{
		Session session = HibernateSessionFactory.getSession();
        String hql="select u from User as u where u.username=:username and u.password=:password";	
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		List<User> listUser = query.list();
		session.close();	
		if(listUser.size() != 0)
			return listUser.get(0).getUserID();		
		else
			return 0;				
	}
}
