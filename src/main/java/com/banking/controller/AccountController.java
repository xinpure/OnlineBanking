package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    System.out.println(account);
    accountService.openAccount(account);
    return "redirect:/admin-panel.jsp";
  }
  
  @RequestMapping(value = "/freezeReleaseAccount", method = RequestMethod.GET)
  public String getFreezeAccountForm() {
    return "freeze-account";
  }
  
  @RequestMapping(value = "/freezeReleaseAccount", params = "Freeze",
      method = RequestMethod.POST)
  public String processFreezeAccountForm(
      @RequestParam("account") String accountType,
      @RequestParam("username") String username) {
    accountService.freezeAccount(username, accountType);
    return "redirect:/admin-panel.jsp";
  }
  
//  
//  @RequestMapping
//  public String list(Model model) {
//    model.addAttribute("accounts", accountService.getAccounts());
//    return "all";
//  }
//  
//  @RequestMapping("all")
//  public String accounts(Model model) {
//    model.addAttribute("accounts", accountService.getAccounts());
//    return "all";
//  }
//  
//  @RequestMapping("/{status}")
//  public String getAccountsByStatus(Model model,
//      @PathVariable("status") boolean accountStatus) {
//    model.addAttribute("accounts",
//        accountService.getAccountByStatus(accountStatus));
//    return "all";
//  }
//  
//  @RequestMapping("/account")
//  public String getAccountById(@RequestParam("id") int accountId, Model model) {
//    model.addAttribute("account", accountService.getAccount(accountId));
//    return "detail";
//  }
//  
//  @RequestMapping(value = "/add", method = RequestMethod.GET)
//  public String getOpenAccountForm(Model model) {
//    Account account = new Account();
//    model.addAttribute("newAccount", account);
//    return "openAccount";
//  }
//  
//  @RequestMapping(value = "/add", method = RequestMethod.POST)
//  public String processOpenAccountForm(@ModelAttribute("newAccount") Account a) {
//    accountService.openAccount(a);
//    return "redirect:/accounts";
//  }
//  
  @InitBinder
  public void initialiseBinder(WebDataBinder binder) {
    binder.setDisallowedFields("openDate");
  }
}
