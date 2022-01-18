package by.akimova.educationSystem.service;

import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.UserDto;

import java.util.List;

/*****************************************************************************************
 * Service interface for class {@link User}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto update(Long id, UserDto userDto);

    void deleteById(Long id);

    UserDto findByMail(String mail);
}
