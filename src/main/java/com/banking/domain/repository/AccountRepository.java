package com.banking.domain.repository;

import java.util.List;

import com.banking.domain.Account;

public interface AccountRepository {
  
  boolean openAccount(Account account);
  
  boolean freezeAccount(String username, String accountType);
}
