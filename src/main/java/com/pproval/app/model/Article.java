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
  private String review;
  private String article;
  private String author;
  private Status status;

  public enum Status {
    SUBMITTED,
    INREVIEW,
    ACCEPTED,
    REJECTED;
  }

  public Article(String author, String name, String article) {
    this.author = author;
    this.name = name;
    this.article = article;
    this.status = Status.SUBMITTED;
  }
}
