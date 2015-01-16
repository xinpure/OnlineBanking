package com.banking.service.impl;

import java.util.List;

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

  public List<User> viewUsers() {
    return userRepository.getUsers();
  }

  public boolean editUser(User user) {
    return userRepository.editUser(user);
  }

  public boolean removeUser(int userID) {
    return userRepository.removeUser(userID);
  }

  public boolean changePassword(int userID, String password) {
    return userRepository.changePassword(userID, password);                      
  }
  
  public String forgetPassword(String username, String email, String ssn) {
    return userRepository.forgetPassword(username, email, ssn);
  }
  
  public int getUserID(String username, String password) {
    return userRepository.getUserID(username, password);
  }
}
