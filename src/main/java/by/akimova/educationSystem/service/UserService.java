package by.akimova.educationSystem.service;

import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.CreateUserDto;
import by.akimova.educationSystem.service.dto.UpdateUserDto;
import by.akimova.educationSystem.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

/*****************************************************************************************
 * Service interface for class {@link User}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Component
public interface UserService {
    UserDto save(CreateUserDto createUserDto);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto update(Long id, UpdateUserDto updateUserDto);

    void deleteById(Long id);

    UserDto findByMail(String mail);
}
