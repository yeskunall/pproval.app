package com.pproval.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.pproval.app.model.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class EditorController {
  @Autowired
  UserRepository userRepo;
  @Autowired
  ArticleRepository articleRepo;

  public static User currentUser;

  @GetMapping("/home-Editor")
  public String homeEditor() {
    return "home-Editor";
  }

  @GetMapping("/assignReviewer-Editor")
  public String assignReviewer(Model model) {
    model.addAttribute("articles",
      articleRepo.findByStatus(Article.Status.SUBMITTED));
    model.addAttribute("reviewer", new Reviewer());
    model.addAttribute("reviewers", userRepo.findByType("Reviewer"));
    return "assignReviewer-Editor";
  }

  @PostMapping("/reviewerAssigned")
  public String reviewerAssigned(@ModelAttribute(name = "articleId") int ID,
                                 @ModelAttribute(name = "reviewer") User user,
                                 Model model)
  {
    List<User> usersAsList =
      userRepo.findByUsernameAndType(user.getUsername(), "Reviewer");
    if (usersAsList.isEmpty()) {
      model.addAttribute("articles",
        articleRepo.findByStatus(Article.Status.SUBMITTED));
      model.addAttribute("reviewer", new Reviewer());
      model.addAttribute("reviewers", userRepo.findByType("Reviewer"));
      return "assignReviewer-Editor";
    }
    User reviewer = usersAsList.get(0);
    Article article = articleRepo.findById(ID).get();
    article.setReviewer(reviewer);
    article.setStatus(Article.Status.INREVIEW);
    articleRepo.save(article);
    model.addAttribute("articles", articleRepo.findAll());
    return "view-Editor";
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
    model.addAttribute("articles", articleRepo.findByStatus(Article.Status.INREVIEW));
    return "approveReject-Editor";
  }


}
