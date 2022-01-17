package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import by.akimova.educationSystem.model.User;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

public class UserTestUtils {

    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private Role role;
    private LocalDateTime birthDate;
    private LocalDateTime registeredTime;
    private LocalDateTime updatedTime;

    public UserTestUtils withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserTestUtils withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserTestUtils withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserTestUtils withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserTestUtils withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public UserTestUtils withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserTestUtils withRole(Role role) {
        this.role = role;
        return this;
    }

    public UserTestUtils withBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserTestUtils withRegisteredTime(LocalDateTime registeredTime) {
        this.registeredTime = registeredTime;
        return this;
    }

    public UserTestUtils withUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public User build() {
        User user = new User();
        return user;
    }


}
