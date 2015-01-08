package com.banking.domain.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.banking.domain.Account;
import com.banking.domain.Checking;
import com.banking.domain.CreditCard;
import com.banking.domain.Saving;
import com.banking.domain.User;
import com.banking.domain.repository.AccountRepository;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
  private HibernateBaseDao helper = new HibernateBaseDao();

  public boolean openAccount(String username, Account account)
  {
    if (account instanceof Checking) {
      return openChecking(username, (Checking) account);
    }
    else if (account instanceof Saving) {
      return openSaving(username, (Saving) account);
    }
    else if (account instanceof CreditCard) {
      return openCreditCard(username, (CreditCard) account);
    }
    return false;
  }
  
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
  
  public boolean freezeAccount(String username, String accountType) {
    return actionAccount(username, accountType, "freeze");
  }
  
  public boolean releaseAccount(String username, String accountType) {
    return actionAccount(username, accountType, "available");
  }
  
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
