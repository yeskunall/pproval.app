package com.pproval.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue
  private Integer id = null;

  protected String type;

  @NotBlank(message="user must have username")
  String username;
  @NotBlank(message="user must have password")
  String password;

  public User(String username, String password){
    this.username = username;
    this.password = password;
  }

  public User(){ }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getType() {
    return type;
  }

  public void setType(String type){
    this.type = type;
  }
}
