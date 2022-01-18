package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.mappers.UserMapper;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.repository.UserRepository;
import by.akimova.educationSystem.service.dto.UserDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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

//@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    private UserServiceImpl userServiceImpl;
    private UserDto firstUser;
    private UserDto secondUser;
    private User userToSave;
    private List<UserDto> users;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userServiceImpl = new UserServiceImpl(userRepository, userMapper);

        firstUser = userMapper.mapToDto(UserTestUtils.createValidUser());

        users = userMapper.mapToListDto(UserTestUtils.createUserList());

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
    void givenUserEntity_WhenSaveUser_ThenSaveAndObtainUser() {
    }

    @Test
    void givenUserId_WhenFindUserById_ThenObtainUser() {
        when(userRepository.findById(firstUser.getId()))
                .thenReturn(Optional.of(userMapper.mapToEntity(firstUser)));
        assertThat(userServiceImpl.getById((firstUser.getId()))).isEqualTo(firstUser);
    }

    @Test
    void givenAllUsers_WhenGetCountOfUsers_ThenObtainNumberOfUsers() {
        when(userMapper.mapToListDto(userRepository.findAll())).thenReturn(userMapper.mapToListDto(userMapper.mapDtoToEntityList(users)));
        List<UserDto> users1 = userServiceImpl.getAll();
        assertEquals(users1, users);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void givenUserEntity_WhenUpdateUser_ThenSaveAndObtainUser() {
    }

    @Test
    void givenUserById_WhenDeleteUser_ThenDropUser() {
        userServiceImpl.deleteById(firstUser.getId());
        verify(userRepository, times(1)).deleteById(firstUser.getId());

    }

    @Test
    void givenUserMail_WhenFindUserByMail_ThenObtainUser() {
    }
}