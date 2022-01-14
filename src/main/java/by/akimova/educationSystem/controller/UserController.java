package by.akimova.educationSystem.controller;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * The method add new user.
     * <p>
     * This is item with its information and body.
     *
     * @return response with body of created user and status ok.
     */

   /* @ApiOperation (value = "Create user", notes = "Create user based on DTO object")
    @ApiImplicitParam (name = "userDto", value = "userDto", required = true, dataType = "UserDto")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "User crated"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })*/
    @PostMapping("")
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
  /*  @ApiOperation (value = "Get list of users", notes = "Get list of users")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Getting all users"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })*/
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * The method shows user by id.
     *
     * @param id This is id of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    /*@ApiOperation(value = "Get information about user", notes = "Get information about user by id")
    @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Getting user"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })*/
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

    /**
     * The method shows user by mail.
     *
     * @param mail This is mail of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    @GetMapping("mail/{mail}")
    ResponseEntity<?> getUserByMail(@PathVariable(value = "mail") String mail) throws EntityNotFoundException {
        User user;
        try {
            user = userService.findByMail(mail).orElseThrow(
                    () -> new EntityNotFoundException("User doesn't exists!"));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

    /**
     * The method update item.
     *
     * @param id   This is user's id which should be updated.
     * @param user This is new body for user which should be updated.
     * @return response with body of updated user and status ok.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDto user) {
        User updatedUser;
        try {
            updatedUser = userService.updateUser(id, user);
        } catch (EntityNotFoundException e) {
            log.error("IN UserController updateUser - user by id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * The method delete user.
     *
     * @param id This is user's id which should be deleted.
     * @return response status no_content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}