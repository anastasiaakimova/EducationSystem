package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Data
@Builder
@Component
@Schema(description = "User entity")
public class UserDto {
    @Schema(required = true, accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(name = "firstName", description = "User's first name", required = true)
    private String firstName;
    @Schema(name = "lastName", description = "User's last name", required = true)
    private String lastName;
    @Schema(name = "mail", description = "User's email", required = true)
    private String mail;
    @Schema(description = "User's password", required = true)
    private String password;
    @Schema(description = "User's gender")
    private Gender gender;
    @Schema(description = "User's phone number")
    private String phoneNumber;
    @Schema(description = "User's role")
    private Role role;
    @Schema(description = "User's date of birthday")
    private LocalDateTime birthDate;
    @Schema(description = "User's date of registration", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime registeredTime;
    @Schema(description = "User's date of last account update", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedTime;

}
