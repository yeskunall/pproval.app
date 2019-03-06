package com.pproval.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerName {

  @GetMapping ("/submit")
  public String submit(){
    return "submit";
  }

  @GetMapping ("/home")
  public String home() {
    return "home";
  }

  @GetMapping ("/view")
  public String view() {
    return "view";
  }
}
