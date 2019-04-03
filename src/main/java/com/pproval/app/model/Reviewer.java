package com.pproval.app.model;

import javax.persistence.Entity;

@Entity
public class Reviewer extends User {

  public Reviewer(String username, String password){
    super(username, password);
    type ="Reviewer";
  }

  public Reviewer(){ }
}
