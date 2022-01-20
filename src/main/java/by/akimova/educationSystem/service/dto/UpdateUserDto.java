package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
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
public class UpdateUserDto extends BaseUserDto {
    @Builder
    public UpdateUserDto(String firstName, String lastName, Gender gender,
                         String phoneNumber, LocalDateTime birthDate) {
        super(firstName, lastName, gender, phoneNumber, birthDate);
    }
}
