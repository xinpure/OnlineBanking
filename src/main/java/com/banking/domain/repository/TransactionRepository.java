package com.banking.domain.repository;

import java.util.List;

import com.banking.domain.Transaction;

public interface TransactionRepository {

  List<List<Transaction>> viewTrans(int userID);
  
  String paidbyCreditCard(int userID, int CVN, String expireDate);
  
  String withdrawMoney(int userID, String accountType, double amount);
  
  String transferMoney(int userID, String method, double amount);
}
