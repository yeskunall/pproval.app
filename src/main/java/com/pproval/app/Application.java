//package com.pproval.app;
package com.pproval.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
            SpringApplication.run(Application.class,args);
    }


//    @Bean
//    public CommandLineRunner demo(ArticleRepository articleRepo, UserRepository userRepo){
//        return (args) -> {
//            //SET UP USERS IN DATABASE
//            Submitter submit = new Submitter("Robyn","Van Gool");
//            Editor editor = new Editor("Pragya", "Singh");
//            Reviewer reviewer = new Reviewer("Ryan", "Ribiero");
//
//            userRepo.save(submit);
//            userRepo.save(editor);
//            userRepo.save(reviewer);
//
//            //USE CASE: log in validation: Submitter
//            List<User> users = userRepo.findByUsernameAndPassword("Invalid","Log in");
//            if (users.isEmpty())
//                log.info("No user found. Enter correct credentials");
//
//            //We can assume no two users with the same username and password are entered into the system therefore list size = 1
//            else {
//
//                log.info("User is of " + users.get(0).getClass().toString());
//                //We can now redirect the application accordingly.
//            }
//
//            users = userRepo.findByUsernameAndPassword("Robyn","Van Gool");
//            if (users.isEmpty())
//                log.info("No user found. Enter correct credentials");
//
//                //We can assume no two users with the same username and password are entered into the system therefore list size = 1
//            else {
//
//                log.info("User is of " + users.get(0).getClass().toString());
//                //We can now redirect the application accordingly.
//            }
//            Submitter currentUser = (Submitter)users.get(0);
//
//            //USE CASE: Submit article (Will occur in Submitter controller)
//            File file = new File("M:\\ArticleSubmission\\test.txt"); //Sorry hard coded path TOFIX
//            String articleName = "Name (set by Submitter)";
//            TextFile textFile = new TextFile(file.getName(), Files.readAllBytes(file.toPath()));
//            Article article = new Article(currentUser, articleName, textFile);
//            articleRepo.save(article);
//
//            //USE CASE: View status of all submitted articles
//            for (Article dbArticle: articleRepo.findBySubmitter(currentUser))
//                log.info("Status of article: "+ dbArticle.getName() + " is... " + dbArticle.getStatus());
//
//
//            //USE CASE: Editor - assign submitter
//            Article submittedArticle = null;
//            for (Article dbArticle: articleRepo.findByStatus(Article.Status.SUBMITTED))
//                submittedArticle = dbArticle; // whichever they choose
//
//            for (User dbreviewer: userRepo.findByType("Reviewer"))
//                reviewer = (Reviewer) dbreviewer;
//
//            submittedArticle.setReviewer(reviewer);
//            submittedArticle.setDeadline(new Date());
//            submittedArticle.setStatus(Article.Status.INREVIEW);
//
//            log.info("Article reviewer is....." + submittedArticle.getReviewer().getUsername());
//            log.info("Deadline to review is...." + submittedArticle.getDeadline());
//            log.info("Status of article is....." + submittedArticle.getStatus());
//        };
//    }
}



