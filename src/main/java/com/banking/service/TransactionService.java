package com.banking.service;

import java.util.List;

import com.banking.domain.Transaction;

public interface TransactionService {

  List<List<Transaction>> viewTrans(int userID);
}
