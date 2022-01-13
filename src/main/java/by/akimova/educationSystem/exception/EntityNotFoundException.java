package by.akimova.educationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*****************************************************************************************
 * This is exception class for catching empty entity.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super("user not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
