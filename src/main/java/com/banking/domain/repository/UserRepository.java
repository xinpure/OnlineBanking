package com.banking.domain.repository;

import java.util.Date;

import com.banking.domain.User;

public interface UserRepository {

  boolean addUser(User user);
  
  boolean login(User user);
  
  User getUserById(int userID);
  
  
}
