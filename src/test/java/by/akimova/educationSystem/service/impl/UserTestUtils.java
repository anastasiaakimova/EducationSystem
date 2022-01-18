package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import by.akimova.educationSystem.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

public class UserTestUtils {

    public static User createValidUser() {
        var today = LocalDateTime.now();

        var user = User.builder()
                .id(8888L)
                .firstName("Alex")
                .lastName("Zxcvbn")
                .birthDate(today)
                .mail("asd@mail")
                .phoneNumber("765432")
                .password("admin")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .registeredTime(today)
                .updatedTime(today)
                .build();

        return user;
    }

    public static List<User> createUserList() {

        var today = LocalDateTime.now();

        List<User> users = new ArrayList<>();

        var firstUser = User.builder()
                .id(5L)
                .firstName("Alex")
                .lastName("Zxcvbn")
                .birthDate(today)
                .mail("asd@mail")
                .phoneNumber("765432")
                .password("admin")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .registeredTime(today)
                .updatedTime(today)
                .build();


        var secondUser = User.builder()
                .id(6L)
                .firstName("Mary")
                .lastName("Zxcvbn")
                .birthDate(today)
                .mail("arewqsd@mail")
                .phoneNumber("7654364332")
                .password("admin")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .registeredTime(today)
                .updatedTime(today)
                .build();

        users.add(firstUser);
        users.add(secondUser);

        return users;
    }
}
