package com.banking.domain;

import java.util.Date;

public class User implements java.io.Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;    
    // Fields

    private int userID;
    private String username;
    private String password;
    private String phoneNum;
    private String address;
    private String email;
    private Date birth;
    private String ssn;
    private boolean available;
    
    /** default constructor */
    public User() {
        
    }
    
    /** full constructor */ 
    public User(int userID, String username, String password,
            String phoneNum, String address, String email, Date birth,
            String ssn, boolean available) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email = email;
        this.birth = birth;
        this.ssn = ssn;
        this.available = available;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof User)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    User u = (User) obj;
    return this.userID == u.userID;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + userID;
    return result;
  }
}
