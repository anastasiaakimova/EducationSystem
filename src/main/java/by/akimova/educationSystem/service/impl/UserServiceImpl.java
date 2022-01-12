package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.repository.UserRepo;
import by.akimova.educationSystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*****************************************************************************************
 * The class is implementation of user's business logic.
 * The class is implementation of  {@link UserService} interface.
 * Wrapper for {@link UserRepo} + business logic.
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

    private final UserRepo userRepo;
    //private final BCryptPasswordEncoder passwordEncoder;

    /**
     * The method add new user.
     *
     * @param user This is user with information about it, and it's fields
     * @return Saved user.
     */
    public User save(User user) throws NotFreeUsernameException {
        LocalDateTime today = LocalDateTime.now();
        Optional mailUser = userRepo.findByMail(user.getMail());
        if (mailUser.isPresent()) {
            throw new NotFreeUsernameException("This username is already taken");
        }
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setMail(user.getMail());
        user.setBirthDate(user.getBirthDate());
        user.setPassword(user.getPassword());
        user.setGender(user.getGender());
        user.setRole(user.getRole());
        user.setRegisteredTime(today);
        user.setUpdatedTime(today);
        log.info("IN saveUser - new user with id: {} successfully added", user.getId());
        userRepo.save(user);
        return user;
    }

    /**
     * The method show user with all information about it.
     *
     * @param id This is user's id.
     * @return found user.
     */
    @Override
    public User getById(Long id) throws EntityNotFoundException {
        User user = userRepo.findUserById(id);
        if (user == null) {
            log.error("IN getById -  no user found by id {}", id);
            throw new EntityNotFoundException("user not found");
        }
        log.info("IN getById - user: {} found by id: {}", user, id);

        return user;
    }

    /**
     * The method show all users with all information about it.
     *
     * @return list of users.
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        log.info("IN getAllUsers - {} users found", users.size());
        return users;
    }

    /**
     * This method update user.
     *
     * @param id   This is user's id which needed to update.
     * @param user This is updated user.
     * @return Updated user.
     */
    @Override
    public User updateUser(Long id, User user) throws EntityNotFoundException {
        LocalDateTime today = LocalDateTime.now();

        User dbUser = userRepo.findUserById(id);
        if (dbUser == null) {
            log.error("IN updateUser - user not found by id {}", id);
            throw new EntityNotFoundException("user not found");
        }
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setMail(user.getMail());
        dbUser.setPhoneNumber(user.getPhoneNumber());
        dbUser.setRole(user.getRole());
        dbUser.setGender(user.getGender());
        dbUser.setUpdatedTime(today);

        log.info("IN updateUser - user with id: {} successfully edited ", id);

        return userRepo.save(dbUser);
    }

    /**
     * This method delete user.
     *
     * @param id This is user's id which needed to delete.
     */
    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteUserById(id);
        log.info("IN deleteUserById - user with id: {} successfully deleted", id);
    }

    /**
     * The method find user by mail and show all information about it.
     *
     * @param mail This is user's mail.
     * @return found user.
     */
    @Override
    public Optional<User> findByMail(String mail) throws EntityNotFoundException {
        Optional<User> user = userRepo.findByMail(mail);
        if (!user.isPresent()) {
            log.error("IN findByMail - user not found by mail: {}", mail);
            throw new EntityNotFoundException("User doesn't exists");
        }

        log.info("IN findByMail - user found by mail: {}", mail);
        return user;
    }
}