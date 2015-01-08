package com.banking.domain.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.banking.domain.Checking;
import com.banking.domain.CheckingTrans;
import com.banking.domain.CreditCard;
import com.banking.domain.CreditCardTrans;
import com.banking.domain.Saving;
import com.banking.domain.SavingTrans;
import com.banking.domain.Transaction;
import com.banking.domain.repository.TransactionRepository;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

  private HibernateBaseDao helper = new HibernateBaseDao();

  public List<List<Transaction>> viewTrans(int userID) {
    List<List<Transaction>> transLists = new ArrayList<List<Transaction>>();
    transLists.add(viewCheckingTrans(userID));
    transLists.add(viewSavingTrans(userID));
    transLists.add(viewCreditCardTrans(userID));
    return transLists;
  }
  public List<Transaction> viewCheckingTrans(int userID) {
    Session session = HibernateSessionFactory.getSession();
    String hql="select ct from CheckingTrans as ct where ct.userID=:userID";    
    Query query = session.createQuery(hql);
    query.setInteger("userID", userID);
    List<Transaction> listCheckingTrans = query.list();
    session.close();
    if(listCheckingTrans.size() != 0)
      return listCheckingTrans;   
    else
      return null;        
  }

  public List<Transaction> viewSavingTrans(int userID) {
    Session session = HibernateSessionFactory.getSession();
    String hql="select st from SavingTrans as st where st.userID=:userID";  
    Query query = session.createQuery(hql);
    query.setInteger("userID", userID);
    List<Transaction> listSavingTrans = query.list();
    session.close();
    if(listSavingTrans.size() != 0)
      return listSavingTrans; 
    else
      return null;            
  }

  public List<Transaction> viewCreditCardTrans(int userID) {
    Session session = HibernateSessionFactory.getSession();
    String hql="select cct from CreditCardTrans as cct where cct.userID=:userID";   
    Query query = session.createQuery(hql);
    query.setInteger("userID", userID);
    List<Transaction> listCardTrans = query.list();
    session.close();
    if(listCardTrans.size() != 0)
      return listCardTrans;   
    else
      return null;        
  }

  public String paidbyCreditCard(int userID, int CVN, String expireDate)
  {
    Session session = HibernateSessionFactory.getSession();
    String hql="select cc from CreditCard as cc where cc.userID=:userID";   
    Query query = session.createQuery(hql);
    query.setInteger("userID", userID);
    List<CreditCard> listCard = query.list();       
    if(listCard.size() != 0)
    {
      if(listCard.get(0).getStatus().equals("available"))
      {
        if(listCard.get(0).getExpireDate().equals(expireDate))
        {
          if(listCard.get(0).getCVN() == CVN)
          {
            listCard.get(0).setBalance(listCard.get(0).getBalance()-100.0);
            if(helper.update(listCard.get(0)))
            {   
              CreditCardTrans cct = new CreditCardTrans();
              cct.setAmount(-100);
              cct.setAvailableAmount(listCard.get(0).getBalance());
              cct.setCardID(listCard.get(0).getCardID());
              cct.setUserID(userID);
              cct.setTransDate(new Date());
              cct.setDetail("Paid by credit card");
              if(transCreditCard(cct))
                return "Success!";
              else
              {
                session.close();
                return "Update credit card transaction fail!";                              
              }
            }       
            else
            {
              session.close();
              return "Update credit card fail!";
            }       
          }
          else
          {
            session.close();
            return "Wrong CVN!";
          }                       
        }
        else
        {
          session.close();
          return "Wrong expire date!";
        }               
      }
      else
      {
        session.close();
        return "Credit Card is frozen!";
      }       
    }
    else
    {
      session.close();
      return "Credit Card dont exist!";
    }   
  }

  public String withdrawMoney(int userID, String accountType, double amount)
  {
    if(accountType.equals("checking"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql="select c from Checking as c where c.userID=:userID";    
      Query query = session.createQuery(hql);
      query.setInteger("userID", userID);
      List<Checking> listChecking = query.list(); 
      if(listChecking.size() != 0)
      {
        if(listChecking.get(0).getStatus().equals("available"))
        {
          if(listChecking.get(0).getBalance() >= amount)
          {
            listChecking.get(0).setBalance(listChecking.get(0).getBalance()-amount);
            if(helper.update(listChecking.get(0)))
            {
              CheckingTrans ct = new CheckingTrans();
              ct.setAmount(-amount);
              ct.setAvailableAmount(listChecking.get(0).getBalance());
              ct.setCheckingID(listChecking.get(0).getCheckingID());
              ct.setUserID(userID);
              ct.setTransDate(new Date());
              ct.setDetail("Withdraw from checking");
              if(transChecking(ct))
                return "Success!";
              else
              {
                session.close();
                return "Update checking transaction fail!";                             
              }
            }       
            else
            {
              session.close();
              return "Update checking fail!";
            }                               
          }
          else
          {
            session.close();
            return "Checking is not enough money!";
          }               
        }
        else
        {
          session.close();
          return "Checking is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Checking dont exist!";
      }   
    }
    else if(accountType.equals("saving"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql="select s from Saving as s where s.userID=:userID";  
      Query query = session.createQuery(hql);
      query.setInteger("userID", userID);
      List<Saving> listSaving = query.list(); 
      if(listSaving.size() != 0)
      {
        if(listSaving.get(0).getStatus().equals("available"))
        {
          if(listSaving.get(0).getBalance() >= amount)
          {
            listSaving.get(0).setBalance(listSaving.get(0).getBalance()-amount);
            if(helper.update(listSaving.get(0)))
            {
              SavingTrans st = new SavingTrans();
              st.setAmount(-amount);
              st.setAvailableAmount(listSaving.get(0).getBalance());
              st.setSavingID(listSaving.get(0).getSavingID());
              st.setUserID(userID);
              st.setTransDate(new Date());
              st.setDetail("Withdraw from saving");
              if(transSaving(st))
                return "Success!";
              else
              {
                session.close();
                return "Update saving transaction fail!";                               
              }
            }       
            else
            {
              session.close();
              return "Update saving fail!";
            }                               
          }
          else
          {
            session.close();
            return "Saving is not enough money!";
          }               
        }
        else
        {
          session.close();
          return "Saving is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Saving dont exist!";
      }               
    }
    else
      return "Wrong account type!";
  }

  public String transferMoney(int userID, String method, double amount)
  {
    if(method.equals("from checking to saving"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql1="select c from Checking as c where c.userID=:userID";   
      Query query1 = session.createQuery(hql1);
      query1.setInteger("userID", userID);
      List<Checking> listChecking = query1.list();    
      if(listChecking.size() != 0)
      {
        if(listChecking.get(0).getStatus().equals("available"))
        {               
          String hql2="select s from Saving as s where s.userID=:userID"; 
          Query query2 = session.createQuery(hql2);
          query2.setInteger("userID", userID);
          List<Saving> listSaving = query2.list();        
          if(listSaving.size() != 0)
          {
            if(listSaving.get(0).getStatus().equals("available"))
            {
              if(listChecking.get(0).getBalance() >= amount)
              {
                listChecking.get(0).setBalance(listChecking.get(0).getBalance()-amount);
                listSaving.get(0).setBalance(listSaving.get(0).getBalance()+amount);
                if(helper.update(listChecking.get(0)) && helper.update(listSaving.get(0)))
                {
                  CheckingTrans ct = new CheckingTrans();
                  ct.setAmount(-amount);
                  ct.setAvailableAmount(listChecking.get(0).getBalance());
                  ct.setCheckingID(listChecking.get(0).getCheckingID());
                  ct.setUserID(userID);
                  ct.setTransDate(new Date());
                  ct.setDetail("Transfer from checking to saving");
                  SavingTrans st = new SavingTrans();
                  st.setAmount(amount);
                  st.setAvailableAmount(listSaving.get(0).getBalance());
                  st.setSavingID(listSaving.get(0).getSavingID());
                  st.setUserID(userID);
                  st.setTransDate(new Date());
                  st.setDetail("Transfer from checking to saving");
                  if(transChecking(ct) && transSaving(st))
                    return "Success!";
                  else
                  {
                    session.close();
                    return "Update transaction fail!";                              
                  }
                }       
                else
                {
                  session.close();
                  return "Update account fail!";
                }                               
              }
              else
              {
                session.close();
                return "Checking is not enough money!";
              }               
            }
            else
            {
              session.close();
              return "Saving is frozen!";
            }       
          }   
          else
          {
            session.close();
            return "Saving dont exist!";
          }                                   
        }
        else
        {
          session.close();
          return "Checking is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Checking dont exist!";
      }               
    }
    else if(method.equals("from saving to checking"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql1="select s from Saving as s where s.userID=:userID"; 
      Query query1 = session.createQuery(hql1);
      query1.setInteger("userID", userID);
      List<Saving> listSaving = query1.list();    
      if(listSaving.size() != 0)
      {
        if(listSaving.get(0).getStatus().equals("available"))
        {               
          String hql2="select c from Checking as c where c.userID=:userID";   
          Query query2 = session.createQuery(hql2);
          query2.setInteger("userID", userID);
          List<Checking> listChecking = query2.list();        
          if(listChecking.size() != 0)
          {
            if(listChecking.get(0).getStatus().equals("available"))
            {
              if(listSaving.get(0).getBalance() >= amount)
              {
                listChecking.get(0).setBalance(listChecking.get(0).getBalance()+amount);
                listSaving.get(0).setBalance(listSaving.get(0).getBalance()-amount);
                if(helper.update(listChecking.get(0)) && helper.update(listSaving.get(0)))
                {
                  SavingTrans st = new SavingTrans();
                  st.setAmount(-amount);
                  st.setAvailableAmount(listSaving.get(0).getBalance());
                  st.setSavingID(listSaving.get(0).getSavingID());
                  st.setUserID(userID);
                  st.setTransDate(new Date());
                  st.setDetail("Transfer from saving to checking");
                  CheckingTrans ct = new CheckingTrans();
                  ct.setAmount(amount);
                  ct.setAvailableAmount(listChecking.get(0).getBalance());
                  ct.setCheckingID(listChecking.get(0).getCheckingID());
                  ct.setUserID(userID);
                  ct.setTransDate(new Date());
                  ct.setDetail("Transfer from saving to checking");
                  if(transSaving(st) && transChecking(ct))
                    return "Success!";
                  else
                  {
                    session.close();
                    return "Update transaction fail!";                              
                  }
                }       
                else
                {
                  session.close();
                  return "Update account fail!";
                }                               
              }
              else
              {
                session.close();
                return "Saving is not enough money!";
              }               
            }
            else
            {
              session.close();
              return "Checking is frozen!";
            }       
          }   
          else
          {
            session.close();
            return "Checking dont exist!";
          }                                   
        }
        else
        {
          session.close();
          return "Saving is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Saving dont exist!";
      }               
    }
    else if(method.equals("from checking to credit card"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql1="select c from Checking as c where c.userID=:userID";   
      Query query1 = session.createQuery(hql1);
      query1.setInteger("userID", userID);
      List<Checking> listChecking = query1.list();    
      if(listChecking.size() != 0)
      {
        if(listChecking.get(0).getStatus().equals("available"))
        {               
          String hql2="select cc from CreditCard as cc where cc.userID=:userID";  
          Query query2 = session.createQuery(hql2);
          query2.setInteger("userID", userID);
          List<CreditCard> listCard = query2.list();      
          if(listCard.size() != 0)
          {
            if(listCard.get(0).getStatus().equals("available"))
            {
              if(listChecking.get(0).getBalance() >= amount)
              {
                listChecking.get(0).setBalance(listChecking.get(0).getBalance()-amount);
                listCard.get(0).setBalance(listCard.get(0).getBalance()+amount);
                if(helper.update(listChecking.get(0)) && helper.update(listCard.get(0)))
                {
                  CheckingTrans ct = new CheckingTrans();
                  ct.setAmount(-amount);
                  ct.setAvailableAmount(listChecking.get(0).getBalance());
                  ct.setCheckingID(listChecking.get(0).getCheckingID());
                  ct.setUserID(userID);
                  ct.setTransDate(new Date());
                  ct.setDetail("Transfer from checking to credit card");
                  CreditCardTrans cct = new CreditCardTrans();
                  cct.setAmount(amount);
                  cct.setAvailableAmount(listCard.get(0).getBalance());
                  cct.setCardID(listCard.get(0).getCardID());
                  cct.setUserID(userID);
                  cct.setTransDate(new Date());
                  cct.setDetail("Transfer from checking to credit card");
                  if(transChecking(ct) && transCreditCard(cct))
                    return "Success!";
                  else
                  {
                    session.close();
                    return "Update transaction fail!";                              
                  }
                }       
                else
                {
                  session.close();
                  return "Update account fail!";
                }                               
              }
              else
              {
                session.close();
                return "Checking is not enough money!";
              }               
            }
            else
            {
              session.close();
              return "CreditCard is frozen!";
            }       
          }   
          else
          {
            session.close();
            return "CreditCard dont exist!";
          }                                   
        }
        else
        {
          session.close();
          return "Checking is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Checking dont exist!";
      }               
    }
    else if(method.equals("from saving to credit card"))
    {
      Session session = HibernateSessionFactory.getSession();
      String hql1="select s from Saving as s where s.userID=:userID"; 
      Query query1 = session.createQuery(hql1);
      query1.setInteger("userID", userID);
      List<Saving> listSaving = query1.list();    
      if(listSaving.size() != 0)
      {
        if(listSaving.get(0).getStatus().equals("available"))
        {               
          String hql2="select cc from CreditCard as cc where cc.userID=:userID";  
          Query query2 = session.createQuery(hql2);
          query2.setInteger("userID", userID);
          List<CreditCard> listCard = query2.list();      
          if(listCard.size() != 0)
          {
            if(listCard.get(0).getStatus().equals("available"))
            {
              if(listSaving.get(0).getBalance() >= amount)
              {
                listSaving.get(0).setBalance(listSaving.get(0).getBalance()-amount);
                listCard.get(0).setBalance(listCard.get(0).getBalance()+amount);
                if(helper.update(listSaving.get(0)) && helper.update(listCard.get(0)))
                {

                  SavingTrans st = new SavingTrans();
                  st.setAmount(-amount);
                  st.setAvailableAmount(listSaving.get(0).getBalance());
                  st.setSavingID(listSaving.get(0).getSavingID());
                  st.setUserID(userID);
                  st.setTransDate(new Date());
                  st.setDetail("Transfer from saving to credit card");
                  CreditCardTrans cct = new CreditCardTrans();
                  cct.setAmount(amount);
                  cct.setAvailableAmount(listCard.get(0).getBalance());
                  cct.setCardID(listCard.get(0).getCardID());
                  cct.setUserID(userID);
                  cct.setTransDate(new Date());
                  cct.setDetail("Transfer from saving to credit card");
                  if(transSaving(st) && transCreditCard(cct))
                    return "Success!";
                  else
                  {
                    session.close();
                    return "Update transaction fail!";                              
                  }
                }       
                else
                {
                  session.close();
                  return "Update account fail!";
                }                               
              }
              else
              {
                session.close();
                return "Saving is not enough money!";
              }               
            }
            else
            {
              session.close();
              return "CreditCard is frozen!";
            }       
          }   
          else
          {
            session.close();
            return "CreditCard dont exist!";
          }                                   
        }
        else
        {
          session.close();
          return "Saving is frozen!";
        }       
      }   
      else
      {
        session.close();
        return "Saving dont exist!";
      }               
    }
    else
      return "Wrong method type!";
  }

  public boolean transCreditCard(CreditCardTrans cct)
  {
    if(helper.save(cct))
      return true;
    else
      return false;       
  }

  public boolean transSaving(SavingTrans st)
  {
    if(helper.save(st))
      return true;
    else
      return false;           
  }

  public boolean transChecking(CheckingTrans ct)
  {
    if(helper.save(ct))
      return true;
    else
      return false;           
  }
}
