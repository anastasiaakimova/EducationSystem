package by.akimova.educationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*****************************************************************************************
 * This is exception class for catching users those who add and use existing in the database usernames.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFreeUsernameException extends RuntimeException {

    public NotFreeUsernameException() {
        super("This username is already taken!");
    }

    public NotFreeUsernameException(String message) {
        super(message);
    }
}
