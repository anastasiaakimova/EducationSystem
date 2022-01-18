package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.mappers.UserMapper;
import by.akimova.educationSystem.repository.UserRepository;
import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    /**
     * The method add new user.
     *
     * @param userDto This is user with information about it, and it's fields
     * @return Saved user.
     */
    @Transactional()
    public UserDto save(UserDto userDto) throws NotFreeUsernameException {
        var today = LocalDateTime.now();

        var mailUser = userRepository.findByMail(userDto.getMail())
                .orElseThrow(
                        () -> new NotFreeUsernameException("This username is already taken"));

        userDto.setFirstName(userDto.getFirstName());
        userDto.setLastName(userDto.getLastName());
        userDto.setMail(userDto.getMail());
        userDto.setBirthDate(userDto.getBirthDate());
        userDto.setPassword(userDto.getPassword());
        userDto.setGender(userDto.getGender());
        userDto.setPhoneNumber(userDto.getPhoneNumber());
        userDto.setRole(userDto.getRole());
        userDto.setRegisteredTime(today);
        userDto.setUpdatedTime(today);

        log.info("IN saveUser - new user with id: {} successfully added", userDto.getId());

        userRepository.save(UserMapper.INSTANCE.mapToEntity(userDto));
        return userDto;
    }

    /**
     * The method show user with all information about it.
     *
     * @param id This is user's id.
     * @return found user.
     */
    @Override
    public UserDto getById(Long id) {
        UserDto userDto = UserMapper.INSTANCE.mapToDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found")));

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
        List<UserDto> users = UserMapper.INSTANCE.mapToListDto(userRepository.findAll());
        log.info("IN getAllUsers - {} users found", users.size());

        return users;
    }

    /**
     * This method update user.
     *
     * @param id      This is user's id which needed to update.
     * @param userDto This is updated user.
     * @return Updated user.
     */
    @Override
    @Transactional()
    public UserDto update(Long id, UserDto userDto) {
        var today = LocalDateTime.now();

        var dbUser = userRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("user not found"));

        userDto.setId(id);

        log.info("IN updateUser - user with id: {} successfully edited ", id);

        return UserMapper.INSTANCE.mapToDto(userRepository.save(UserMapper.INSTANCE.mapToEntity(userDto)));
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

        return userMapper.mapToDto(mailUser);
    }
}