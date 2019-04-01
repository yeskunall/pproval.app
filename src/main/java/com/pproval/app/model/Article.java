package com.pproval.app.model;

import javax.persistence.*;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id = null;
  private String name;
  private Date submission;
  private Date deadline;
  @OneToOne
  private Reviewer reviewer;
  @OneToOne
  private Submitter submitter;
  private String review;
  private String article;
  private Status status;

  public enum Status {
    SUBMITTED,
    INREVIEW,
    ACCEPTED,
    REJECTED;
  }

  public Article(Submitter submitter, String name, String article){
    this.submitter = submitter;
    this.name = name;
    this.article = article;
    this.status = Status.SUBMITTED;
  }
}
