package com.banking.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

public class Chart {
  public List<Map<String, Object>> pieFindInfo() {
    
    Session session = HibernateSessionFactory.getSession();
    String hql1 = "select count(*) from Account as a where a.status='freeze'";
    Query query1 = session.createQuery(hql1);
    int freezeCount = ((Long) query1.uniqueResult()).intValue();
    String hql2 = "select count(*) from Account as a where a.status='available'";
    Query query2 = session.createQuery(hql2);
    int availableCount = ((Long) query2.uniqueResult()).intValue();
    session.close();
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    Map<String, Object> map1 = new HashMap<String, Object>();
    Map<String, Object> map2 = new HashMap<String, Object>();
    map1.put("status", "freeze");
    map1.put("num", freezeCount);
    list.add(map1);
    map2.put("status", "available");
    map2.put("num", availableCount);
    list.add(map2);     
    return list;
  }
}
