package com.banking.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

  int userID = 13;

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
  public String processLoginForm(@ModelAttribute("user") User user, Model model,
      HttpSession session) {
    boolean loginStatus = userService.login(user);
    if (loginStatus == false) {
      model.addAttribute("loginStatus", "Login failed");
      return "user-login";
    }
    System.out.println(user.getUsername());    
    System.out.println(user.getUserID());
    session.setAttribute("userID", user.getUserID());
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

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String getUsersForm(Model model) {
    List<User> userList = new ArrayList<User>();
    userList = userService.viewUsers();
    model.addAttribute("userList", userList);
    return "view-user";
  }

  @RequestMapping(value = "/readUser", method = RequestMethod.GET)
  public String getUserForm(@RequestParam(value = "userID") int userID,
      Model model) {
    model.addAttribute("userID", userID);
    return "redirect:/users";
  }

  @RequestMapping(value = "/editUser", method = RequestMethod.POST)
  public String editUser(
      @RequestParam(value = "userID") int userID,
      @RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password,
      @RequestParam(value = "address") String address,
      @RequestParam(value = "contact") String contact,
      @RequestParam(value = "email") String email,
      @RequestParam(value = "birth") String birth,
      @RequestParam(value = "ssn") String ssn,
      @RequestParam(value = "available") boolean available) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Date date = null;
    try {
      date = sdf.parse(birth);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    User user = new User(userID, username, password, contact, address, email,
        date, ssn, available);
    userService.editUser(user);
    return "redirect:/users";
  }

  @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
  public String removeUser(@RequestParam(value = "userID") int userID) {
    userService.removeUser(userID);
    return "redirect:/users";
  }
  
  @RequestMapping(value = "/password", method = RequestMethod.GET)
  public String getChangePasswordForm() {
    return "change-password";
  }
  
  @RequestMapping(value = "/password", method = RequestMethod.POST)
  public String processChangePasswordForm(
      @RequestParam("password") String password) {
    userService.changePassword(userID, password);
    return "user-panel";
  }
  
  @RequestMapping(value = "/forget", method = RequestMethod.GET)
  public String getForgetPasswordForm() {
    return "forget-password";
  }
  
  @RequestMapping(value = "/forget", method = RequestMethod.POST)
  public String processForgetPasswordForm(Model model,
      @RequestParam("username") String username,
      @RequestParam("email") String email,
      @RequestParam("ssn") String ssn) {
    String password = userService.forgetPassword(username, email, ssn);
    model.addAttribute("password", password);
    return "forget-password";
  }

  @InitBinder
  public void bindingPreparation(WebDataBinder binder) {
    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    CustomDateEditor orderDateEditor = new CustomDateEditor(df, true);
    binder.registerCustomEditor(Date.class, "birth", orderDateEditor);
  }
}
