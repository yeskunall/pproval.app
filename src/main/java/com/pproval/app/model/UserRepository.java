package com.pproval.app.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    List<User> findByUsername(@Param("username") String username);
    List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    List<User> findByType(@Param("type") String type);
}

