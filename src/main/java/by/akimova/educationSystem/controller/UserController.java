package by.akimova.educationSystem.controller;

import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User", description = "REST controller user connected requests")
public class UserController {

    private final UserService userService;

    /**
     * The method add new user.
     *
     * @param userDto This is dto with all information and body.
     * @return response with body of created user and status ok.
     */


    @PostMapping("")
    @Operation(
            summary = "Create user",
            description = "Create user based on DTO object",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User crated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })

    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.save(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * The method shows all users.
     *
     * @return ResponseEntity with list of users and status ok.
     */
    @GetMapping
    @Operation(
            summary = "Get list of users",
            description = "Get list of users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Getting list of users",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    /**
     * The method shows user by id.
     *
     * @param id This is id of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */

    @GetMapping("/{id}")
    @Operation(
            summary = "Get user by id",
            description = "Get information about user by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Getting user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })
    public ResponseEntity<?> getById(@PathVariable(value = "id")
                                     @Parameter(description = "user's id",
                                             schema = @Schema(
                                                     type = "Long"))
                                             Long id) {
        UserDto userDto = userService.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * The method shows user by mail.
     *
     * @param mail This is mail of the person to be found.
     * @return ResponseEntity with found user and status ok.
     */
    @GetMapping("mail/{mail}")
    @Operation(
            summary = "Get user by mail",
            description = "Get information about user by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Getting user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })
    ResponseEntity<?> getByMail(@PathVariable(value = "mail")
                                @Parameter(description = "user's mail",
                                        schema = @Schema(
                                                type = "String")) String mail) {
        UserDto userDto = userService.findByMail(mail);
        return ResponseEntity.ok(userDto);
    }

    /**
     * The method update item.
     *
     * @param id      This is user's id which should be updated.
     * @param userDto This is new body for user which should be updated.
     * @return response with body of updated user and status ok.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Update user",
            description = "Update user's information",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Getting updated user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })
    public ResponseEntity<?> update(@PathVariable(value = "id")
                                    @Parameter(description = "user's id",
                                            schema = @Schema(
                                                    type = "Long"))
                                            Long id,
                                    @RequestBody UserDto userDto) {
        var updatedUser = userService.update(id, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * The method delete user.
     *
     * @param id This is user's id which should be deleted.
     * @return response status no_content.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete user",
            description = "Delete user and all his information",
            responses = {
                    @ApiResponse(responseCode = "200", description = "user deleted",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Something went wrong", content = @Content)
            })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}