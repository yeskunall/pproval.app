package com.pproval.app.model;

import javax.persistence.Entity;

@Entity
public class Editor extends User {

  public Editor(String username, String password){
    super(username, password);
    type = "Editor";
  }

  public Editor(){ }
}
