package com.banking.service;

import com.banking.domain.Account;

public interface AccountService {
  
  boolean openAccount(String username, Account account);
  
  boolean freezeAccount(String username, String accountType);
  
  boolean releaseAccount(String username, String accountType);

}
