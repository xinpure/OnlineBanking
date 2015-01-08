package com.banking.service;

import java.util.List;

import com.banking.domain.User;

public interface UserService {

  void addUser(User user);
  
  boolean login(User user);
  
  boolean adminLogin(String username, String password);
  
  List<User> viewUsers();
  
  boolean editUser(User user);
  
  boolean removeUser(int userID);
  
  boolean changePassword(int userID, String password);
}
