package com.pproval.app.model;

import javax.persistence.Entity;

@Entity
public class Submitter extends User {

  public Submitter(String username, String password){
    super(username, password);
    type = "Submitter";
  }

  public Submitter(){ }
}
