package com.iss.po;


public class Files {

  private String fid;
  private String fname;
  private String fsize;
  private String ftype;
  private String fpath;
  private java.sql.Timestamp fuploadTime;


  public String getFid() {
    return fid;
  }

  public void setFid(String fid) {
    this.fid = fid;
  }


  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }


  public String getFsize() {
    return fsize;
  }

  public void setFsize(String fsize) {
    this.fsize = fsize;
  }


  public String getFtype() {
    return ftype;
  }

  public void setFtype(String ftype) {
    this.ftype = ftype;
  }


  public String getFpath() {
    return fpath;
  }

  public void setFpath(String fpath) {
    this.fpath = fpath;
  }


  public java.sql.Timestamp getFuploadTime() {
    return fuploadTime;
  }

  public void setFuploadTime(java.sql.Timestamp fuploadTime) {
    this.fuploadTime = fuploadTime;
  }

}
