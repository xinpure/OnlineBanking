package com.banking.service;

import com.banking.domain.User;

public interface UserService {

  void addUser(User user);
  
  boolean login(User user);
  
  boolean adminLogin(String username, String password);
}
