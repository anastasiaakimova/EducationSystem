package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
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
@NoArgsConstructor
public class CreateUserDto extends BaseUserDto {

    @Schema(name = "mail", description = "User's email", required = true)
    private String mail;
    @Schema(description = "User's password", required = true)
    private String password;

    @Builder
    public CreateUserDto(String firstName, String lastName, Gender gender, String phoneNumber,
                         String password, LocalDateTime birthDate, String mail) {
        super(firstName, lastName, gender, phoneNumber, birthDate);
        this.mail = mail;
        this.password = password;
    }
}
