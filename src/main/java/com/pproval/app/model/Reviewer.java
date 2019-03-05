package com.pproval.app.model;

import javax.persistence.Entity;

@Entity
public class Reviewer extends User {
    private final String type ="Reviewer";

    public Reviewer(String username, String password){
        super(username, password);
    }

    public Reviewer(){ }
}
