//package com.banking.domain.repository.impl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.banking.domain.Account;
//import com.banking.domain.repository.AccountRepository;
//
//@Repository
//public class InMemoryAccountRepository implements AccountRepository {
//
//  private List<Account> listOfAccounts = new ArrayList<Account>();
//
//  public InMemoryAccountRepository() {
//    Account a1 = new Account(1, new Date(), true);
//    Account a2 = new Account(2, new Date(), false);
//    Account a3 = new Account(3, new Date(), true);
//    listOfAccounts.add(a1);
//    listOfAccounts.add(a2);
//    listOfAccounts.add(a3);
//  }
//  public List<Account> getAccounts() {
//    return listOfAccounts;
//  }
//  public Account getAccount(int id) {
//    Account a = null;
//    for (Account account : listOfAccounts) {
//      if (account != null && account.getAccount_id() == id) {
//        a = account;
//        break;
//      }
//    }
//    if (a == null) {
//      throw new IllegalArgumentException();
//    }
//    return a;
//  }
//  public List<Account> getAccountByStatus(boolean status) {
//    List<Account> accountsByStatus = new ArrayList<Account>();
//    for (Account a : listOfAccounts) {
//      if (a.getStatus() == status) {
//        accountsByStatus.add(a);
//      }
//    }
//    return accountsByStatus;
//  }
//  public void openAccount(Account account) {
//    listOfAccounts.add(account);
//  }
//}
