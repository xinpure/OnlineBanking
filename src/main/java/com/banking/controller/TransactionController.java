package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.domain.Transaction;
import com.banking.service.TransactionService;

@Controller
public class TransactionController {

  @Autowired
  private TransactionService transactionService;
 
  int userID = 13;
  
  @RequestMapping(value = "/balance", method = RequestMethod.GET)
  public String getBalance(Model model) {
    List<List<Transaction>> transLists = transactionService.viewTrans(userID);
    model.addAttribute("checkingTrans", transLists.get(0));
    model.addAttribute("savingTrans", transLists.get(1));
    model.addAttribute("creditCardTrans", transLists.get(2));
    System.out.println(transLists);
    return "account-balance";
  }
  
  @RequestMapping(value = "/pay", method = RequestMethod.GET)
  public String getPayForm() {
    return "credit-card";
  }
  
  @RequestMapping(value = "/pay", method = RequestMethod.POST)
  public String processPayForm(
      @RequestParam("expire") String expireDate,
      @RequestParam("cvn") String cvn) {
    int CVN = Integer.parseInt(cvn);
    transactionService.paidbyCreditCard(userID, CVN, expireDate);
    return "redirect:/balance";
  }
  
  @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
  public String getWithdrawForm() {
    return "withdraw";
  }
  
  @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
  public String processWithdrawForm(
      @RequestParam("account") String accountType,
      @RequestParam("money") String money) {
    Double amount = Double.parseDouble(money);
    transactionService.withdrawMoney(userID, accountType, amount);
    return "redirect:/balance";
  }
  
  @RequestMapping(value = "/transfer", method = RequestMethod.GET)
  public String getTransferForm() {
    return "transfer";
  }
  
  @RequestMapping(value = "/transfer", method = RequestMethod.POST)
  public String processTransferForm(
      @RequestParam("account") String method,
      @RequestParam("money") String money) {
    Double amount = Double.parseDouble(money);
    transactionService.transferMoney(userID, method, amount);
    return "redirect:/balance";
  }
}
