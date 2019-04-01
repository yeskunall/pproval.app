package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewerTest {

  private  Reviewer reviewer;

  @Before
  public void setUp() throws Exception {
    reviewer = new Reviewer("username", "password");
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getType() {
    assertEquals("Type should be 'Reviewer'.", "Reviewer",
      reviewer.getType());
  }

  @Test
  public void getUsername() {
    assertEquals("Username should be 'username'.", "username",
      reviewer.getUsername());
  }

  @Test
  public void getPassword() {
    assertEquals("Password should be 'password'.","password",
      reviewer.getPassword());
  }

  @Test
  public void setUsername() {
    reviewer.setUsername("newUsername");
    assertEquals("Username should be 'newUsername'.", "newUsername",
      reviewer.getUsername());
  }

  @Test
  public void setPassword() {
    reviewer.setPassword("newPassword");
    assertEquals("Password should be 'newPassword'.", "newPassword",
      reviewer.getPassword());
  }
}
