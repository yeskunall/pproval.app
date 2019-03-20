package com.pproval.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

  @GetMapping("/home-Submitter")
  public String home() { return "home-Submitter"; }

  @GetMapping("/submit-Submitter")
  public String submit() {
    return "submit-Submitter";
  }

  @GetMapping("/view-Submitter")
  public String view() {
    return "view-Submitter";
  }

}
