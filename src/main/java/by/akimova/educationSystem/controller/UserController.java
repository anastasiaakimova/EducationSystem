package by.akimova.educationSystem.controller;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****************************************************************************************
 * REST controller user connected requests.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    /**
     * The method add new user.
     *
     * @param user This is item with its information and body.
     * @return response with body of created user and status ok.
     */
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User savedUser;
        try {
            savedUser = userService.save(user);
        } catch (NotFreeUsernameException e) {
            return new ResponseEntity<>("This username is already taken ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * The method shows all users.
     *
     * @return ResponseEntity with list of users and status ok.
     */
    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * The method shows user by id.
     *
     * @param id This is id of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id) {
        User user;
        try {
            user = userService.getById(id);
        } catch (EntityNotFoundException e) {
            log.error("IN UserController getUserById - user by id {} not found", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}