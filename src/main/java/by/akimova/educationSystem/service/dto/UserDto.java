package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import lombok.Data;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Data
public class UserDto {

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

}
