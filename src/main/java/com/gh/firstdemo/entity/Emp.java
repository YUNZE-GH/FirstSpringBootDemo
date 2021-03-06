package com.gh.firstdemo.entity;


import java.io.Serializable;

public class Emp implements Serializable {

  private String id;
  private String name;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"id\":\"")
            .append(id).append('\"');
    sb.append(",\"name\":\"")
            .append(name).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
