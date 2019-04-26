package com.iss.po;


public class Users {

  private String uname;
  private String upwd;


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUpwd() {
    return upwd;
  }

  public void setUpwd(String upwd) {
    this.upwd = upwd;
  }

  @Override
  public String toString() {
    return "Users{" +
            "uname='" + uname + '\'' +
            ", upwd='" + upwd + '\'' +
            '}';
  }
}
