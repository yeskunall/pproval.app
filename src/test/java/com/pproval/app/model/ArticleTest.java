package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {

  private Submitter submitter;
  private Reviewer reviewer;
  private Article article;

  @Before
  public void setUp() throws Exception {
    submitter = new Submitter("subUsername", "subPassword");
    reviewer = new Reviewer("revUsername", "revPassword");
    article = new Article(submitter, "Final Project Report", "Just pretend " +
      "this is my final report.");
    article.setReviewer(reviewer);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getName() {
    assertEquals("Name should be 'Final Project Report'.", "Final Project " +
      "Report", article.getName());
  }

  @Test
  public void getReviewer() {
    assertEquals("Reviewers should match.", reviewer, article.getReviewer());
  }

  @Test
  public void getSubmitter() {
    assertEquals("Submitters should match.", submitter,
      article.getSubmitter());
  }

  @Test
  public void getStatus() {
    assertEquals("Review should be SUBMITTED.", Article.Status.SUBMITTED,
      article.getStatus());
  }

  @Test
  public void getArticle() {
    assertEquals("Article text should match.", "Just pretend this is my final" +
      " report.", article.getArticle());
  }

  @Test
  public void setName() {
    article.setName("New Title");
    assertEquals("Name should be 'New Title'.", "New Title",
      article.getName());
  }

  @Test
  public void setArticle() {
    article.setArticle("New text.");
    assertEquals("Article body should match.", "New text.",
      article.getArticle());
  }

  @Test
  public void setStatus() {
    article.setStatus(Article.Status.ACCEPTED);
    assertEquals("Review should be ACCEPTED.", Article.Status.ACCEPTED,
      article.getStatus());
  }
}
