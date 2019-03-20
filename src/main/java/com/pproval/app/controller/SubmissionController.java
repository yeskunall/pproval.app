package com.pproval.app.controller;

import com.pproval.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmissionController {
  @Autowired
  UserRepository userRepository;
  @Autowired
  ArticleRepository articleRepository;

  Submitter currentUser;


  @GetMapping("/home-Submitter")
  public String home() {
    //Temporary solution since we don't have user login fully handled yet
    if (currentUser == null) {
      currentUser = new Submitter("Ryan-Submitter", "safepassword123");
      userRepository.save(currentUser);
      Article submittedArticleOne = new Article(currentUser, "My First Article", "This is my first article that I have ever submitted. I am quite proud of it!");
      Article submittedArticleTwo = new Article(currentUser, "My Second Article","This is my second article that I have ever submitted and boy let me tell you, the rush has not yet worn off." );
      articleRepository.save(submittedArticleOne);
      articleRepository.save(submittedArticleTwo);
    }
    return "home-Submitter";
  }

  @GetMapping("/submit-Submitter")
  public String submit() {
    return "submit-Submitter";
  }

  @GetMapping("/view-Submitter")
  public String view(Model model) {
    model.addAttribute("articles", articleRepository.findAll());
    return "view-Submitter";
  }
}
