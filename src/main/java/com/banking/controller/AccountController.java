//package com.banking.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.banking.domain.Account;
//import com.banking.service.AccountService;
//
//@Controller
//@RequestMapping("/accounts")
//public class AccountController {
//
//  @Autowired
//  private AccountService accountService;
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
//  @InitBinder
//  public void initialiseBinder(WebDataBinder binder) {
//    binder.setDisallowedFields("account_date");
//  }
//}
