package com.banking.domain.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.banking.domain.User;
import com.banking.domain.repository.UserRepository;
import com.banking.util.HibernateBaseDao;
import com.banking.util.HibernateSessionFactory;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private HibernateBaseDao helper = new HibernateBaseDao();

  public boolean addUser(User user) {
    if(helper.save(user))
      return true;
    else
      return false;           
  }

  public boolean login(User user) {

    String username = user.getUsername();
    String password = user.getPassword();
    Session session = HibernateSessionFactory.getSession();
    String hql="select u from User as u where u.username=:username " +
        "and u.password=:password";
    Query query=session.createQuery(hql);   
    query.setString("username", username);
    query.setString("password", password);
    List<User> listUser = query.list();
    session.close();
    if(listUser.size() != 0) {
      System.out.println("login success");
      return true;
    }
    else {
      System.out.println("login failed");
      return false;
    }
  }

  public boolean doLogin(String username, String password) {

    Session session = HibernateSessionFactory.getSession();
    String hql="select u from User as u where u.username=:username " +
        "and u.password=:password";
    Query query=session.createQuery(hql);   
    query.setString("username", username);
    query.setString("password", password);
    List<User> listUser = query.list();
    session.close();
    if(listUser.size() != 0)
      return true;
    else
      return false;
  }

  public User getUserById(int userID) {
    // TODO Auto-generated method stub
    return null;
  }
}
