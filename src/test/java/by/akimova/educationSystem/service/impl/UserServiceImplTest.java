package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/*****************************************************************************************
 * Testing class for {@link UserServiceImpl}
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userServiceImpl;
    private User firstUser;
    private User secondUser;
    private User userToSave;
    private List<User> users;

    @BeforeEach
    public void setUp() {

        userServiceImpl = new UserServiceImpl(userRepository);

        var today = LocalDateTime.now();

        firstUser = new UserTestUtils()
                .withFirstName("Alex")
                .withLastName("Zxcvbn")
                .withMail("asd@mail")
                .withPhoneNumber("765432")
                .withPassword("admin")
                .withRole(Role.ADMIN)
                .withGender(Gender.FEMALE)
                .withRegisteredTime(today)
                .withUpdatedTime(today)
                .withBirthDate(today)
                .build();

        users.add(firstUser);

        secondUser = new UserTestUtils()
                .withFirstName("Qwerty")
                .withLastName("Zxcvbn")
                .withMail("zxcvb@maill")
                .withPhoneNumber("765432")
                .withPassword("admin")
                .withRole(Role.ADMIN)
                .withGender(Gender.FEMALE)
                .withRegisteredTime(today)
                .withUpdatedTime(today)
                .withBirthDate(today)
                .build();

        users.add(secondUser);

        userToSave = new User();
        userToSave.setMail("asd@mail");
        userToSave.setPassword(("user"));

    }

    @AfterEach
    public void tearDown() {
        firstUser = secondUser = null;
        users = null;
    }

    @Test
    void save() {
    }

    @Test
    void getById() {
    }

    @Test
    void givenUserId_WhenGetCountOfWrote_ThenObtainNumberOfWrotePiece() {
        when(userRepository.findAll()).thenReturn(users);
        List<User> users1 = userServiceImpl.getAll();
        assertEquals(users1, users);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void findByMail() {
    }
}