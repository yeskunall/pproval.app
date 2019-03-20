package com.pproval.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.pproval.app.model.*;
import org.springframework.ui.Model;

@Controller
public class EditorController {
  @Autowired
  UserRepository userRepo;
  @Autowired
  ArticleRepository articleRepo;

  Editor currentUser;

  @GetMapping("/home-Editor")
  public String homeEditor() {
    if (currentUser == null) {
      Editor editor = new Editor("Pragya", "Singh");
      userRepo.save(editor);
      currentUser = editor;
      Submitter s1 = new Submitter("John", "Password1");
      Submitter s2 = new Submitter("Mary", "P1");
      userRepo.save(s1);
      userRepo.save(s2);
      Article a1 = new Article(s1,
        "Twinkle Twinkle", "Twinkle twinkle little star how I wonder what you" +
        " are. Up above the world so high. Like a diamond in the sky. Twinkle" +
        " twinklw little star. How I wonder what you are");
      Article a2 = new Article(s2,
        "Frere Jacques", "FrËre Jacques, FrËre Jacques, Dormez-vous? " +
        "Dormez-vous? Sonnez les matines! Sonnez les matines! Ding, dang, " +
        "dong. Ding, dang, dong.");
      articleRepo.save(a1);
      articleRepo.save(a2);
    }
    return "home-Editor";
  }

  @GetMapping("/assignReviewer-Editor")
  public String assignReviewer() {
    return "assignReviewer-Editor";
  }

  @GetMapping("/approveReject-Editor")
  public String approveReject() {
    return "approveReject-Editor";
  }

  @GetMapping("/view-Editor")
  public String viewEditor(Model model) {
    model.addAttribute("articles", articleRepo.findAll());
    return "view-Editor";
  }
}
