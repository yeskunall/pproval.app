package com.pproval.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class User {
    private final String type = "User";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;

    String username;
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
}
