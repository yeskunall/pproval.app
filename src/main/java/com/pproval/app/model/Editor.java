package com.pproval.app.model;

import javax.persistence.Entity;

@Entity
public class Editor extends User {
  private final String type = "Editor";

  public Editor(String username, String password){
    super(username, password);
  }

  public Editor(){ }
}
