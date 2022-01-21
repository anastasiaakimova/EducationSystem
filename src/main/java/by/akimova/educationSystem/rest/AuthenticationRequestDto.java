package by.akimova.educationSystem.rest;

import lombok.Data;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Data
public class AuthenticationRequestDto {
    private String mail;
    private String password;

}
