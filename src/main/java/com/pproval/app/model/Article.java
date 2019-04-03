package com.pproval.app.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id = null;
  String name;
  Date submission;
  Date deadline;
  @OneToOne
  User reviewer;
  @OneToOne
  User submitter;
  String review;
  String article;
  Status status;

  public enum Status {
    SUBMITTED,
    INREVIEW,
    ACCEPTED,
    REJECTED;
  }

  public Article(User submitter, String name, String article){
    this.submitter = submitter;
    this.name = name;
    this.article = article;
    this.status = Status.SUBMITTED;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public User getReviewer() {
    return reviewer;
  }

  public void setReviewer(User reviewer) {
    this.reviewer = reviewer;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public String getContent() {
    return article;
  }

  public void setArticle(String article) {
    this.article = article;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public User getSubmitter() {
    return submitter;
  }

  public void setSubmitter(User submitter) {
    this.submitter = submitter;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getSubmission() {
    return submission;
  }

  public void setSubmission(Date submission) {
    this.submission = submission;
  }

  public Article(){

  }
}
