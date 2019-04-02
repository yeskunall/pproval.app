package com.pproval.app.integration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class InMemoryAuthTest {
  @Autowired private WebApplicationContext ctx;

  private MockMvc mock;

  @Before
  public void setup() {
    mock =
        MockMvcBuilders.<DefaultMockMvcBuilder>webAppContextSetup(ctx)
            .apply(springSecurity())
            .alwaysDo(print())
            .build();
  }

  @Test
  public void invalidLoginDenied() throws Exception {
    mock.perform(formLogin().password("invalid"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/login?error"))
        .andExpect(unauthenticated());

    mock.perform(get("/login?error"))
        .andExpect(content().string(containsString("Invalid credentials")));
  }

  @Test
  public void loginAvailableForAll() throws Exception {
    mock.perform(get("/login")).andExpect(status().isOk());
  }

  @Test
  public void perform_LoginAsEditor() throws Exception {
    mock.perform(formLogin().user("editor").password("editor"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/"))
        .andExpect(authenticated().withUsername("editor").withRoles("ADMIN", "EDITOR", "USER"));
  }

  @Test
  public void perform_LoginAsReviewer() throws Exception {
    mock.perform(formLogin().user("reviewer").password("reviewer"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/"))
        .andExpect(authenticated().withUsername("reviewer").withRoles("REVIEWER", "USER"));
  }

  @Test
  public void perform_LoginAsSubmitter() throws Exception {
    mock.perform(formLogin().user("submitter").password("submitter"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/"))
        .andExpect(authenticated().withUsername("submitter").withRoles("SUBMITTER", "USER"));
  }

  @Test
  public void requiresAuthentication() throws Exception {
    mock.perform(get("/")).andExpect(redirectedUrl("http://localhost/login"));
  }
}
