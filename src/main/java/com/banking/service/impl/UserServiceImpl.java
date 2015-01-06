package com.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.domain.User;
import com.banking.domain.repository.UserRepository;
import com.banking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  
  public void addUser(User user) {
    userRepository.addUser(user);
  }
  
  public boolean login(User user) {
    return userRepository.login(user);
  }

  public boolean adminLogin(String username, String password) {
      if(username.equals("admin") && password.equals("admin"))
          return true;
      else
          return false;
  }
}
