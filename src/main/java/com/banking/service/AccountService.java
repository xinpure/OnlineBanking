package com.banking.service;

import com.banking.domain.Account;

public interface AccountService {
  
  boolean openAccount(Account account);
  
  boolean freezeAccount(String username, String accountType);
}
