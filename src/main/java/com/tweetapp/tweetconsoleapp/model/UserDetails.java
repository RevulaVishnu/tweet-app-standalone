package com.tweetapp.tweetconsoleapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class UserDetails {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String mobileNumber;
    private boolean online;
}
