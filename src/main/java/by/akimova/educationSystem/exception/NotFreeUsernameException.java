package by.akimova.educationSystem.exception;

/*****************************************************************************************
 * This is exception class for catching users those who add and use existing in the database usernames.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

public class NotFreeUsernameException extends Exception {
    public NotFreeUsernameException(String message) {
        super(message);
    }
}
