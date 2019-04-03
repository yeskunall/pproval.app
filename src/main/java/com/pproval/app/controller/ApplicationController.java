package com.pproval.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.pproval.app.model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ApplicationController {
  @Autowired
  UserRepository userRepo;

  @RequestMapping("/")
  public String home(Model model) {
    model.addAttribute("user", new User());
    return "login-Page"; }



  @RequestMapping ("/login-Page")
  public String loginPage(Model model) {
    model.addAttribute("user", new User());
    return "login-Page";
  }

  @PostMapping("/validateUsername")
  public ModelAndView validateUsername(@ModelAttribute(name = "user") User user){
    List<User> currentUserAsList =
      userRepo.findByUsernameAndPassword(user.getUsername(),
      user.getPassword());
    if (currentUserAsList.isEmpty())
      return new ModelAndView("login-Page");
    User currentUser = currentUserAsList.get(0);
    if(currentUser.getType().equals("Editor")) {
      EditorController.currentUser = user;
      return new ModelAndView("redirect:/home-Editor");
    }
    else if(currentUser.getType().equals("Submitter"))
      return new ModelAndView("redirect:/home-Submitter");
    return new ModelAndView("redirect:/home-Reviewer");
  }



  @GetMapping("/home-Submitter")
  public String editorHome() { return "home-Submitter"; }


  @GetMapping("/submit-Submitter")
  public String submit() {
    return "submit-Submitter";
  }

  @GetMapping("/view-Submitter")
  public String view() {
    return "view-Submitter";
  }
}
