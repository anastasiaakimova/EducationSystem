package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUserDto {
    @Schema(name = "firstName", description = "User's first name", required = true)
    private String firstName;
    @Schema(name = "lastName", description = "User's last name", required = true)
    private String lastName;
    @Schema(description = "User's gender")
    private Gender gender;
    @Schema(description = "User's phone number")
    private String phoneNumber;
    @Schema(description = "User's date of birthday")
    private LocalDateTime birthDate;
}
