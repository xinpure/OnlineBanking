package com.banking.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.domain.User;
import com.banking.domain.repository.UserRepository;
import com.banking.service.UserService;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private HibernateBaseDao helper = new HibernateBaseDao();

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
    Session session = HibernateSessionFactory.getSession();
    String hql="select u from User as u where u.userID=:userID";    
    Query query = session.createQuery(hql);
    query.setInteger("userID", userID);
    List<User> listUser = query.list();
    session.close();    
    if(listUser.size() != 0)
    {
      listUser.get(0).setPassword(password);
      if(helper.update(listUser.get(0)))
        return true;
      else
        return false;           
    }   
    else
      return false;                       
  }
}
