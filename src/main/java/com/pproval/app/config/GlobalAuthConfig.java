package com.pproval.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalAuthentication
public class GlobalAuthConfig {
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        // Starting Spring 5, Spring Security uses `bcrypt` to hash passwords.
        // Bypass that for now, we won’t have in-memory authentication in place
        // anyway
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("user")
        .password("password")
        .roles("USER");
  }
}
