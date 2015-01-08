package com.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.domain.Account;
import com.banking.domain.repository.AccountRepository;
import com.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
  
  @Autowired
  private AccountRepository accountRepository;
  

  public boolean openAccount(String username, Account account) {
    return accountRepository.openAccount(username, account);
  }
  
  public boolean freezeAccount(String username, String accountType) {
    return accountRepository.freezeAccount(username, accountType);
  }
  
  public boolean releaseAccount(String username, String accountType) {
    return accountRepository.releaseAccount(username, accountType);
  }
}
