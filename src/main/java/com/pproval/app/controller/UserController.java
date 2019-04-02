package com.pproval.app.controller;

import com.pproval.app.model.User;
import com.pproval.app.model.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired UserRepository userRepo;

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepo.findAll();
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
    return userRepo.save(user);
  }
}
