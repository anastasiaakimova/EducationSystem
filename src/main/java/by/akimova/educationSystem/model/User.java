package by.akimova.educationSystem.model;

import lombok.Data;

import java.util.Date;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Data
public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private String mail;
    private Gender gender;
    private String phoneNumber;
    private Role role;
    private Date birthTime;
    private Date registerTime;
    private Date updateTime;
}