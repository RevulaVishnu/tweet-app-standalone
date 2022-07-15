package com.tweetapp.tweetconsoleapp.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Tweet {
    @Id
    private String email;
    private String tweet;
    private String tweetedBy;
    @CreationTimestamp
    private Timestamp createdAt;
}
