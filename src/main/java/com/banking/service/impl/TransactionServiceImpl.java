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
}
