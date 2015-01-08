package com.banking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.domain.Transaction;
import com.banking.domain.repository.TransactionRepository;
import com.banking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;
  
  public List<List<Transaction>> viewTrans(int userID) {
    return transactionRepository.viewTrans(userID);
  }
  
  public String paidbyCreditCard(int userID, int CVN, String expireDate) {
    return transactionRepository.paidbyCreditCard(userID, CVN, expireDate);
  }
  
  public String withdrawMoney(int userID, String accountType, double amount) {
    return transactionRepository.withdrawMoney(userID, accountType, amount);
  }
  
  public String transferMoney(int userID, String method, double amount) {
    return transactionRepository.transferMoney(userID, method, amount);
  }
}
