package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.domain.Account;
import com.banking.domain.Checking;
import com.banking.domain.CreditCard;
import com.banking.domain.Saving;
import com.banking.service.AccountService;

@Controller
public class AccountController {

  @Autowired
  private AccountService accountService;

  @RequestMapping(value = "/openAccount", method = RequestMethod.GET)
  public String getOpenAccountForm() {
    return "open-account";
  }

  @RequestMapping(value = "/openAccount", method = RequestMethod.POST)
  public String processOpenAccountForm(
      @RequestParam("account") String accountType,
      @RequestParam("username") String username,
      @RequestParam("money") String money) {
    Account account = null;
    Double balance = Double.parseDouble(money);
    if (accountType.equalsIgnoreCase("checking")) {
      account = new Checking(0, 0, 0, balance);
    }
    else if (accountType.equalsIgnoreCase("saving")) {
      account = new Saving(0, 0, 0, balance);
    }
    else if (accountType.equalsIgnoreCase("credit card")) {
      account = new CreditCard(0, 0, 0, balance);
    }
    accountService.openAccount(username, account);
    return "redirect:/admin-panel.jsp";
  }

  @RequestMapping(value = "/freezeReleaseAccount", method = RequestMethod.GET)
  public String getFreezeAccountForm() {
    return "freeze-account";
  }

  @RequestMapping(value = "/freezeReleaseAccount", method = RequestMethod.POST)
  public String processFreezeAccountForm(
      @RequestParam("account") String accountType,
      @RequestParam("username") String username,
      @RequestParam("action") String actionType) {
    if (actionType.equalsIgnoreCase("freeze")) {
      accountService.freezeAccount(username, accountType);
    }
    else if (actionType.equalsIgnoreCase("available")) {
      accountService.releaseAccount(username, accountType);
    }
    return "redirect:/admin-panel.jsp";
  }

}
