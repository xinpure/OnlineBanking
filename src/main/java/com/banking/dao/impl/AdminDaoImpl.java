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
	public boolean openChecking(String username, Checking account)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql="select u from User as u where u.username=:username";	
		Query query = session.createQuery(hql);
		query.setString("username", username);
		List<User> listUser = query.list();	
		if(listUser.size() != 0)
		{	
			account.setUserID(listUser.get(0).getUserID());
			if(helper.save(account))
				return true;
			else
			{
				session.close();
				return false;
			}
		}
		else
		{
			session.close();
			return false;
		}
	}
	
	public boolean openSaving(String username, Saving account)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql="select u from User as u where u.username=:username";	
		Query query = session.createQuery(hql);
		query.setString("username", username);
		List<User> listUser = query.list();	
		if(listUser.size() != 0)
		{	
			account.setUserID(listUser.get(0).getUserID());
			if(helper.save(account))
				return true;
			else
			{
				session.close();
				return false;
			}	
		}
		else
		{
			session.close();
			return false;
		}
	}
	
	public boolean openCreditCard(String username, CreditCard account)
	{
		Session session = HibernateSessionFactory.getSession();
		String hql="select u from User as u where u.username=:username";	
		Query query = session.createQuery(hql);
		query.setString("username", username);
		List<User> listUser = query.list();	
		if(listUser.size() != 0)
		{	
			account.setUserID(listUser.get(0).getUserID());
			if(helper.save(account))
				return true;
			else
			{
				session.close();
				return false;
			}	
		}
		else
		{
			session.close();
			return false;
		}		
	}
	
	/**
	 * freeze/release account
	 */	
	public boolean actionAccount(String username, String accountType, String method)
	{
		if(accountType.equals("checking"))
		{
			Session session = HibernateSessionFactory.getSession();
			String hql1="select u from User as u where u.username=:username";	
			Query query1 = session.createQuery(hql1);
			query1.setString("username", username);
			List<User> listUser = query1.list();	
			if(listUser.size() != 0)
			{	
				String hql2="select c from Checking as c where c.userID=:userID";	
				Query query2 = session.createQuery(hql2);
				query2.setInteger("userID", listUser.get(0).getUserID());
				List<Checking> listChecking = query2.list();
				if(listChecking.size() != 0)
				{	
					if(helper.search(Checking.class, listChecking.get(0).getAccountID()) != null)
					{
						Checking checking = (Checking)helper.search(Checking.class, listChecking.get(0).getAccountID());
						checking.setStatus(method);
						if(helper.update(checking))
							return true;
						else
						{
							session.close();
							return false;
						}				
					}
					else
					{
						session.close();
						return false;
					}					
				}
				else
				{
					session.close();
					return false;
				}				
			}
			else
			{
				session.close();
				return false;
			}		
					
		}
		else if(accountType.equals("saving"))
		{
			Session session = HibernateSessionFactory.getSession();
			String hql1="select u from User as u where u.username=:username";	
			Query query1 = session.createQuery(hql1);
			query1.setString("username", username);
			List<User> listUser = query1.list();	
			if(listUser.size() != 0)
			{	
				String hql2="select s from Saving as s where s.userID=:userID";	
				Query query2 = session.createQuery(hql2);
				query2.setInteger("userID", listUser.get(0).getUserID());
				List<Saving> listSaving = query2.list();
				if(listSaving.size() != 0)
				{	
					if(helper.search(Saving.class, listSaving.get(0).getAccountID()) != null)
					{				
						Saving saving = (Saving)helper.search(Saving.class, listSaving.get(0).getAccountID());
						saving.setStatus(method);
						if(helper.update(saving))
							return true;
						else
						{
							session.close();
							return false;
						}				
					}
					else
					{
						session.close();
						return false;
					}					
				}
				else
				{
					session.close();
					return false;
				}				
			}
			else
			{
				session.close();
				return false;
			}					
		}
		else if(accountType.equals("credit card"))
		{
			Session session = HibernateSessionFactory.getSession();
			String hql1="select u from User as u where u.username=:username";	
			Query query1 = session.createQuery(hql1);
			query1.setString("username", username);
			List<User> listUser = query1.list();	
			if(listUser.size() != 0)
			{	
				String hql2="select cc from CreditCard as cc where cc.userID=:userID";	
				Query query2 = session.createQuery(hql2);
				query2.setInteger("userID", listUser.get(0).getUserID());
				List<CreditCard> listCard = query2.list();
				if(listCard.size() != 0)
				{	
					if(helper.search(CreditCard.class, listCard.get(0).getAccountID()) != null)
					{
						CreditCard card = (CreditCard)helper.search(CreditCard.class, listCard.get(0).getAccountID());
						card.setStatus(method);
						if(helper.update(card))
							return true;
						else
						{
							session.close();
							return false;
						}				
					}
					else
					{
						session.close();
						return false;
					}					
				}
				else
				{
					session.close();
					return false;
				}				
			}
			else
			{
				session.close();
				return false;
			}				
		}
		else
			return false;
	} 

}
