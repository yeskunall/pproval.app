package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmitterTest {

  private  Submitter submitter;

  @Before
  public void setUp() throws Exception {
    submitter = new Submitter("username", "password");
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getType() {
    assertEquals("Type should be 'Submitter'.", "Submitter",
      submitter.getType());
  }

  @Test
  public void getUsername() {
    assertEquals("Username should be 'username'.", "username",
      submitter.getUsername());
  }

  @Test
  public void getPassword() {
    assertEquals("Password should be 'password'.","password",
      submitter.getPassword());
  }

  @Test
  public void setUsername() {
    submitter.setUsername("newUsername");
    assertEquals("Username should be 'newUsername'.", "newUsername",
      submitter.getUsername());
  }

  @Test
  public void setPassword() {
    submitter.setPassword("newPassword");
    assertEquals("Password should be 'newPassword'.", "newPassword",
      submitter.getPassword());
  }
}
