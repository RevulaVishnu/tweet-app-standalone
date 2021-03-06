package com.tweetapp.tweetconsoleapp.repository;

import com.tweetapp.tweetconsoleapp.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {
}
