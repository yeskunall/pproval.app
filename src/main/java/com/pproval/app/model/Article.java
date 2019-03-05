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
    Reviewer reviewer;
    @OneToOne
    Submitter submitter;
    @OneToOne
    TextFile review;
    @OneToOne(cascade={CascadeType.ALL})
    TextFile article;
    Status status;

    public enum Status {
        SUBMITTED,
        INREVIEW,
        ACCEPTED,
        REJECTED;
    }

    public Article(Submitter submitter, String name, TextFile article){
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

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public TextFile getReview() {
        return review;
    }

    public void setReview(TextFile review) {
        this.review = review;
    }

    public TextFile getArticle() {
        return article;
    }

    public void setArticle(TextFile article) {
        this.article = article;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
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
