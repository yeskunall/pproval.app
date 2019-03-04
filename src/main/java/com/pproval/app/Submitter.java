package com.pproval.app;

import javax.persistence.Entity;

@Entity
public class Submitter extends User {
    private final String type = "Submitter";

    public Submitter(String username, String password){
        super(username, password);
    }

    public Submitter(){ }
}
