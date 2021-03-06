package com.banking.domain.repository;

import com.banking.domain.Account;

public interface AccountRepository {
  
  boolean openAccount(String username, Account account);
  
  boolean freezeAccount(String username, String accountType);
  
  boolean releaseAccount(String username, String accountType);

}
