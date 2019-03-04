package com.pproval.app;

import javax.persistence.Entity;

@Entity
public class Reviewer extends User {
    private final String type ="Reviewer";

    public Reviewer(String username, String password){
        super(username, password);
    }

    public Reviewer(){ }
}
