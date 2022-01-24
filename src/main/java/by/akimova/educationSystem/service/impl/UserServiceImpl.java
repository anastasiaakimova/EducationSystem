package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.mappers.UserMapper;
import by.akimova.educationSystem.model.Role;
import by.akimova.educationSystem.repository.UserRepository;
import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.dto.CreateUserDto;
import by.akimova.educationSystem.service.dto.UpdateUserDto;
import by.akimova.educationSystem.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*****************************************************************************************
 * The class is implementation of user's business logic.
 * The class is implementation of  {@link UserService} interface.
 * Wrapper for {@link UserRepository} + business logic.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * The method add new user.
     *
     * @param createUserDto This is user with information about it, and it's fields
     * @return Saved user.
     */
    @Override
    @Transactional()
    public UserDto save(CreateUserDto createUserDto) {

        var today = LocalDateTime.now();
        var userEntity = userMapper.createUserDtoMapToEntity(createUserDto);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole(Role.USER);
        userEntity.setRegisteredTime(today);
        userEntity.setUpdatedTime(today);

        userRepository.save(userEntity);
        log.info("IN saveUser - new user with id: {} successfully added", userEntity.getId());

        return userMapper.mapToDto(userEntity);
    }

    /**
     * The method show user with all information about it.
     *
     * @param id This is user's id.
     * @return found user.
     */
    @Override
    public UserDto getById(Long id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        var userDto = userMapper.mapToDto(userEntity);
        log.info("IN getById - user: {} found by id: {}", userDto, id);

        return userDto;
    }

    /**
     * The method show all users with all information about it.
     *
     * @return list of users.
     */
    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = userMapper.mapToListDto(userRepository.findAll());
        log.info("IN getAllUsers - {} users found", users.size());

        return users;
    }

    /**
     * This method update user.
     *
     * @param id      This is user's id which needed to update.
     * @param updateUserDto This is updated user.
     * @return Updated user.
     */
    @Override
    @Transactional()
    public UserDto update(Long id, UpdateUserDto updateUserDto) {

        var today = LocalDateTime.now();
        var dbUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));

        dbUser.setFirstName(updateUserDto.getFirstName());
        dbUser.setLastName(updateUserDto.getLastName());
        dbUser.setPhoneNumber(updateUserDto.getPhoneNumber());
        dbUser.setGender(updateUserDto.getGender());
        dbUser.setBirthDate(updateUserDto.getBirthDate());
        dbUser.setUpdatedTime(today);

        userRepository.save(dbUser);
        log.info("IN updateUser - user with id: {} successfully edited ", id);

        return userMapper.mapToDto(dbUser);
    }

    /**
     * This method delete user.
     *
     * @param id This is user's id which needed to delete.
     */
    @Override
    @Transactional()
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        log.info("IN deleteUserById - user with id: {} successfully deleted", id);
    }

    /**
     * The method find user by mail and show all information about it.
     *
     * @param mail This is user's mail.
     * @return found user.
     */
    @Override
    public UserDto findByMail(String mail) throws EntityNotFoundException {

        var mailUser = userRepository.findByMail(mail)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exists"));
        log.info("IN findByMail - user found by mail: {}", mail);
        var userDto = userMapper.mapToDto(mailUser);

        return userDto;
    }
}