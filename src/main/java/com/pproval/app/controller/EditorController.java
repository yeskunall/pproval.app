package com.pproval.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
      Reviewer r1 = new Reviewer("Ryan", "password");
      Reviewer r2 = new Reviewer("Robert", "password2");
      Reviewer r3 = new Reviewer("Jack", "password3");
      Reviewer r4 = new Reviewer("Bob", "password4");
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
      Article b1= new Article(s1,
        "Happy Birthday", "Happy Birthday to you " +
        " You live in a zoo. You smell like a monkey" +
        " and you look like one to. Happy Birthday old man");
      b1.setStatus(Article.Status.INREVIEW);

      Article b2= new Article( s2,
        "O Canada", "O Canada " +
        " Our home and native land" +
        " true patriot love. In all our sons command");
      b2.setReview(" This work is incredible");
      b2.setStatus(Article.Status.INREVIEW);

      Article b3= new Article( s2,
        "Spider", "The itsy bitsy spider " +
        " Climbed up the water fall " +
        " down came the rain and washed the spider out");
      b3.setReview(" This is god awful");
      b3.setStatus(Article.Status.INREVIEW);


      articleRepo.save(b1);
      articleRepo.save(b2);
      articleRepo.save(a1);
      articleRepo.save(a2);
      articleRepo.save(b3);
    }
    return "home-Editor";
  }

  @GetMapping("/assignReviewer-Editor")
  public String assignReviewer(Model model) {
    model.addAttribute("articles",
      articleRepo.findByStatus(Article.Status.SUBMITTED));
    model.addAttribute("reviewers",
      articleRepo.findAll());
    return "assignReviewer-Editor";
  }

  @GetMapping("/approveReject-Editor")
  public String approveReject(Model model) {
    model.addAttribute("articles",
      articleRepo.findByStatus(Article.Status.INREVIEW));
    return "approveReject-Editor";
  }

  @GetMapping("/view-Editor")
  public String viewEditor(Model model) {
    model.addAttribute("articles", articleRepo.findAll());
    return "view-Editor";
  }

  @PostMapping("/articleApprove")
  public String approveArticle(@ModelAttribute(name = "articleId") int ID,
                               Model model){
    Article article = articleRepo.findById(ID).get();
    article.setStatus(Article.Status.ACCEPTED);
    articleRepo.save(article);
    model.addAttribute("articles", articleRepo.findByStatus(Article.Status.INREVIEW));
    return "approveReject-Editor";
  }

  @PostMapping("/articleReject")
  public String rejectArticle(@ModelAttribute(name = "articleId") int ID,
                               Model model){
    Article a1 = articleRepo.findById(ID).get();
    a1.setStatus(Article.Status.REJECTED);
    articleRepo.save(a1);
    return "approveReject-Editor";
  }


}
