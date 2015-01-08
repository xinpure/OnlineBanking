package com.banking.domain.repository;

import java.util.List;

import com.banking.domain.User;

public interface UserRepository {

  boolean addUser(User user);
  
  boolean login(User user);
  
  List<User> getUsers();
  
  boolean editUser(User user);
  
  boolean removeUser(int userID);
  
  boolean changePassword(int userID, String password);
  
}
