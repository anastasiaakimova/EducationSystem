package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.CreateUserDto;
import by.akimova.educationSystem.service.dto.UpdateUserDto;
import by.akimova.educationSystem.service.dto.UserDto;

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
                .mail("as45-0987656d@mail")
                .phoneNumber("765432")
                .password("admin")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .registeredTime(today)
                .updatedTime(today)
                .build();

        return user;
    }

    public static CreateUserDto createValidUserDto() {
        var today = LocalDateTime.now();

        var createUserDto = CreateUserDto.builder()
                .firstName("Alex1")
                .lastName("Zxcvbn1")
                .birthDate(today)
                .mail("as3415d@mail")
                .phoneNumber("7651432")
                .password("admin1")
                .gender(Gender.FEMALE)
                .build();

        return createUserDto;
    }

    public static UpdateUserDto updateValidUserDto() {
        var today = LocalDateTime.now();

        var updateUserDto = UpdateUserDto.builder()
                .firstName("Alex1")
                .lastName("Zxcvbn1")
                .birthDate(today)
                .phoneNumber("7651432")
                .gender(Gender.FEMALE)
                .build();

        return updateUserDto;
    }

    public static UserDto validUserDto() {
        var today = LocalDateTime.now();

        var createUserDto = UserDto.builder()
                .id(88L)
                .firstName("Alex1")
                .lastName("Zxcvbn1")
                .birthDate(today)
                .mail("as3415d@mail")
                .phoneNumber("7651432")
                .password("admin1")
                .role(Role.ADMIN)
                .gender(Gender.FEMALE)
                .build();

        return createUserDto;
    }

    public static List<User> createUserList() {

        var today = LocalDateTime.now();

        List<User> users = new ArrayList<>();

        var firstUser = User.builder()
                .id(5L)
                .firstName("Alex1")
                .lastName("Zxcvbn1")
                .birthDate(today)
                .mail("asd1@mail")
                .phoneNumber("7615432")
                .password("admin1")
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



    public static List<UserDto> createUserDtoList() {

        var today = LocalDateTime.now();

        List<UserDto> users = new ArrayList<>();

        var firstUser = UserDto.builder()
                .id(5L)
                .firstName("Alex1")
                .lastName("Zxcvbn1")
                .birthDate(today)
                .mail("asd1@mail")
                .phoneNumber("7615432")
                .password("admin1")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .registeredTime(today)
                .updatedTime(today)
                .build();


        var secondUser = UserDto.builder()
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
