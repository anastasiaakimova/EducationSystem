package by.akimova.educationSystem.controller;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.exception.NotFreeUsernameException;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.dto.UserDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * The method add new user.
     *
     *  This is item with its information and body.
     * @return response with body of created user and status ok.
     */

    @ApiOperation (value = "Create user", notes = "Create user based on DTO object")
    @ApiImplicitParam (name = "userDto", value = "userDto", required = true, dataType = "UserDto")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User crated"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    @PostMapping("/us")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        User savedUser;

        savedUser = userService.save(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * The method shows all users.
     *
     * @return ResponseEntity with list of users and status ok.
     */
    @GetMapping
    @ApiOperation (value = "Get list of users", notes = "Get list of users")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Getting all users"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * The method shows user by id.
     *
     * @param id This is id of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    @ApiOperation(value = "Get information about user", notes = "Get information about user by id")
    @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Getting user"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id) {
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