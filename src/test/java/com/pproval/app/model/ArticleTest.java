package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {

  private Article article;

  @Before
  public void setUp() throws Exception {
    article = new Article("Ryan", "Final Project Report", "Just pretend " +
      "this is my final report.");
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
  public void getAuthor() {
    assertEquals("Author should be 'Ryan'.", "Ryan",
      article.getAuthor());
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
  public void setAuthor() {
    article.setAuthor("Nobody");
    assertEquals("Author should be 'Nobody'.", "Nobody",
      article.getAuthor());
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
