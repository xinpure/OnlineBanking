package com.banking.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

public class Chart {
  public List<Map<String, Integer>> pieFindInfo() {
    
    Session session = HibernateSessionFactory.getSession();
    String hql1 = "select count(*) from Account as a where a.status='freeze'";
    Query query1 = session.createQuery(hql1);
    int freezeCount = ((Long) query1.uniqueResult()).intValue();
    String hql2 = "select count(*) from Account as a where a.status='available'";
    Query query2 = session.createQuery(hql2);
    int availableCount = ((Long) query2.uniqueResult()).intValue();
    session.close();
    System.out.println(freezeCount + " " + availableCount);
    
    List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("freeze", freezeCount);
    map.put("available", availableCount);
    list.add(map);
    return list;
  }
}
