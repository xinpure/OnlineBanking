package com.banking.util;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 
 */
public class HibernateBaseDao 
{
	public boolean save(Object obj)
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=null;
		try 
		{
			tran=session.beginTransaction();
			session.save(obj);
			tran.commit();
			return true;
		} 
		catch (HibernateException e) 
		{
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			session.close();
		}
	}

	public boolean delete(Object obj)
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=null;
		try 
		{
			tran=session.beginTransaction();
			session.delete(obj);
			tran.commit();
			return true;
		} 
		catch (HibernateException e) 
		{
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			session.close();
		}
	}
	
	public boolean update(Object obj)
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=null;
		try 
		{
			tran=session.beginTransaction();
			session.update(obj);
			tran.commit();
			return true;
		} 
		catch (HibernateException e) 
		{
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			session.close();
		}
	}
	
	public Object search(Class cla,Serializable id)
	{
		Object obj=null;
		Session session=HibernateSessionFactory.getSession();
		obj=session.get(cla, id);
		session.close();
		return obj;
	}
}
