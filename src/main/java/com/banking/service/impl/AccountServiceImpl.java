//package com.banking.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.banking.domain.Account;
//import com.banking.domain.repository.AccountRepository;
//import com.banking.service.AccountService;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//  
//  @Autowired
//  private AccountRepository accountRepository;
//  
//  public void accountDisplay(int id) {
//    Account a = accountRepository.getAccount(id);
//    if (a.getStatus() == false) {
//      a.setAccount_id(22);;
//    }
//  }
//
//  public List<Account> getAccounts() {
//    return accountRepository.getAccounts();
//  }
//
//  public Account getAccount(int id) {
//    return accountRepository.getAccount(id);
//  }
//  
//  public List<Account> getAccountByStatus(boolean status) {
//    return accountRepository.getAccountByStatus(status);
//  }
//  
//  public void openAccount(Account account) {
//    accountRepository.openAccount(account);
//  }
//}
