package com.banking.domain.repository.impl;

import org.springframework.stereotype.Repository;

import com.banking.domain.Account;
import com.banking.domain.Checking;
import com.banking.domain.CreditCard;
import com.banking.domain.Saving;
import com.banking.domain.repository.AccountRepository;
import com.banking.util.HibernateBaseDao;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
  private HibernateBaseDao helper = new HibernateBaseDao();

  public boolean openAccount(Account account) {
    if (account instanceof Checking) {
      return openChecking((Checking) account);
    }
    else if (account instanceof Saving) {
      return openSaving((Saving) account);
    }
    else if (account instanceof CreditCard) {
      return openCreditCard((CreditCard) account);
    }
    return false;
  }
  
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
}
