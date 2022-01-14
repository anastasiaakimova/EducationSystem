package by.akimova.educationSystem.service;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

/*****************************************************************************************
 * Service interface for class {@link User}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

public interface UserService {
    User save(UserDto userDto) throws NotFreeUsernameException;

    User getById(Long id) throws EntityNotFoundException;

    List<User> getAllUsers();

    User updateUser(Long id, UserDto user) throws EntityNotFoundException;

    void deleteUserById(Long id);

    Optional<User> findByMail(String mail) throws EntityNotFoundException;
}
