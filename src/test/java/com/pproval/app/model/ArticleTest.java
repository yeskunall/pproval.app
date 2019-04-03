package com.pproval.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class ArticleTest {
  private final User submit= new Submitter("Pragya", "Password");
  private final Article test= new Article(submit,"Pragya","2cool4school");
  private Date deadline= new Date();
  private final User reviewer= new Reviewer("Pragya","Password");
  private final User temp= new Reviewer("Ryan", "Happy123");

  @Test
  public void setId() {
    test.setId(2);
    assertEquals(test.getId(), 2, 0);
  }

  @Test
  public void getId() {
    assertEquals(test.getId(),null);
  }

  @Test
  public void getDeadline() {
    test.setDeadline(deadline);
    assertEquals(test.getDeadline(),deadline);

  }

  @Test
  public void setDeadline() {
    test.setDeadline(deadline);
    assertEquals(test.getDeadline(),deadline);
  }

  @Test
  public void getReview() {
    //test.setReview("Completed");
    assertEquals(test.getReview(),null);
  }

  @Test
  public void setReview() {
    test.setReview("Failed");
    assertEquals(test.getReview(),"Failed");
  }

  @Test
  public void setReviewer() {
    test.setReviewer(temp);
    assertEquals(test.getReviewer(), temp);


  }
  @Test
  public void getReviewer() {
    assertEquals(test.getReviewer(),null);

  }


  @Test
  public void getContent() {
    assertEquals(test.getContent(),"2cool4school");
  }

  @Test
  public void setArticle() {
    test.setArticle("Changed Article");
    assertEquals(test.getContent(),"Changed Article");
  }

  @Test
  public void getStatus() {
    assertEquals(test.getStatus(), Article.Status.SUBMITTED);
  }
}
