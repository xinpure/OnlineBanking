package com.banking.domain.repository;

import java.util.List;

import com.banking.domain.Transaction;

public interface TransactionRepository {

  List<List<Transaction>> viewTrans(int userID);
}
