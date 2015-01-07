package com.banking.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.banking.domain.Transaction;
import com.banking.domain.repository.TransactionRepository;
import com.banking.util.HibernateSessionFactory;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
  
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
}
