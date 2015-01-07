package com.banking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.domain.Transaction;
import com.banking.service.TransactionService;

@Controller
public class TransactionController {

  @Autowired
  private TransactionService transactionService;
 
  @RequestMapping(value = "/balance", method = RequestMethod.GET)
  public String getBalance(Model model) {
//    int userID = (Integer) session.getAttribute("userID");
//    List<List<Transaction>> transLists = transactionService.viewTrans(userID);
//    model.addAttribute("checkingTrans", transLists.get(0));
//    model.addAttribute("savingTrans", transLists.get(1));
//    model.addAttribute("creditCardTrans", transLists.get(2));
//    System.out.println(transLists);
    return "account-balance";
  }
}
