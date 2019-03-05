package com.pproval.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerName {

  @GetMapping ("/submitTest")
  public String submit(){
    return "submitTest";
  }

  @GetMapping ("/home")
  public String home() {
    return "home";
  }
}
