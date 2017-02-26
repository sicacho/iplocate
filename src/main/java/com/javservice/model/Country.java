package com.javservice.model;

/**
 * Created by Administrator on 2/26/2017.
 */
public class Country {
  String name;
  String isoCode;


  public Country(String name,String isoCode) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }
}
