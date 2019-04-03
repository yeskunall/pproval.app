package com.pproval.app;

import com.pproval.app.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demo(UserRepository userRepo,
                                    ArticleRepository articleRepo) {
    return args -> {

      Editor e1 = new Editor("Pragya", "Password");
      userRepo.save(e1);
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
      userRepo.save(r1);
      userRepo.save(r2);
      userRepo.save(r3);
      userRepo.save(r4);

      articleRepo.save(b1);
      articleRepo.save(b2);
      articleRepo.save(a1);
      articleRepo.save(a2);
      articleRepo.save(b3);
    };
  }
}
