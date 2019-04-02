package com.pproval.app.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
  public User user= new Editor("Pragya","Password");
  @Test
  public void getId() {
    user.setId(4);
    assertEquals(user.getId(), 4,0);
  }

  @Test
  public void setId() {
    user.setId(7);
    assertEquals(user.getId(), 7, 0);
  }

  @Test
  public void getUsername() {
    assertEquals(user.getUsername(),"Pragya");
  }

  @Test
  public void setUsername() {
    user.setUsername("Ryan");
    assertEquals(user.getUsername(),"Ryan");
  }

  @Test
  public void getPassword() {
    assertEquals(user.getPassword(),"Password");
  }

  @Test
  public void setPassword() {
    user.setPassword("New Password");
    assertEquals(user.getPassword(),"New Password");
  }
}
