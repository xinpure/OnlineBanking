package com.banking.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.domain.User;
import com.banking.service.UserService;

@Controller
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String getAddUserForm(Model model) {
    User newUser = new User();
    model.addAttribute("newUser", newUser);
    return "add-new-user";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String processAddUserForm(@ModelAttribute("newUser") User newUser) {
    userService.addUser(newUser);
    return "redirect:/admin-panel.jsp";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLoginForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "user-login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String processLoginForm(@ModelAttribute("user") User user, Model model) {
    boolean loginStatus = userService.login(user);
    if (loginStatus == false) {
      model.addAttribute("loginStatus", "Login failed");
      return "user-login";
    } 
    return "redirect:/user-panel.jsp";
  }
  
  @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
  public String getAdminLoginForm() {
    return "admin-login";
  }
  
  @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
  public String processAdminLoginForm(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password, Model model) {   
    boolean loginStatus = userService.adminLogin(username, password);
    if (loginStatus == false) {
      model.addAttribute("loginStatus", "Login failed");
      return "admin-login";
    }
    return "redirect:/admin-panel.jsp";
  }
  
  @InitBinder
  public void bindingPreparation(WebDataBinder binder) {
    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    CustomDateEditor orderDateEditor = new CustomDateEditor(df, true);
    binder.registerCustomEditor(Date.class, "birth", orderDateEditor);
  }
}
