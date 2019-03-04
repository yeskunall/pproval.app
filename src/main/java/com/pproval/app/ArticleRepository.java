package com.pproval.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

    List<Article> findByName(@Param("name") String name);
    List<Article> findBySubmitter(@Param("submitter") Submitter submitter);
    List<Article> findByDeadline(@Param("deadline") Date deadline);
    List<Article> findByStatus(@Param("status") Article.Status status);
    List<Article> findByReviewer(@Param("reviewer") Reviewer reviewer);
}
