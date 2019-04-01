package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditorTest {

  private  Editor editor;

  @Before
  public void setUp() throws Exception {
    editor = new Editor("username", "password");
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getType() {
    assertEquals("Type should be 'Editor'.", "Editor",
      editor.getType());
  }

  @Test
  public void getUsername() {
    assertEquals("Username should be 'username'.", "username",
      editor.getUsername());
  }

  @Test
  public void getPassword() {
    assertEquals("Password should be 'password'.","password",
      editor.getPassword());
  }

  @Test
  public void setUsername() {
    editor.setUsername("newUsername");
    assertEquals("Username should be 'newUsername'.", "newUsername",
      editor.getUsername());
  }

  @Test
  public void setPassword() {
    editor.setPassword("newPassword");
    assertEquals("Password should be 'newPassword'.", "newPassword",
      editor.getPassword());
  }
}
