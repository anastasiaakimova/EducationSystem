package by.akimova.educationSystem.service.impl;

import by.akimova.educationSystem.exception.EntityNotFoundException;
import by.akimova.educationSystem.mappers.UserMapper;
import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setUp() {

        userServiceImpl = new UserServiceImpl(userRepository, userMapper);

    }

    @Test
    void givenUserEntity_WhenSaveUser_ThenObtainSaveUser() {
        var createUserDto = UserTestUtils.createValidUserDto();
        var userEntity = userMapper.createUserDtoMapToEntity(createUserDto);

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
        var savedUser = userServiceImpl.save((createUserDto));

        assertThat(savedUser.getFirstName()).isEqualTo(userEntity.getFirstName());
    }

    @Test
    void givenUserId_WhenFindUserById_ThenObtainUser() {
        var userEntity = UserTestUtils.createValidUser();
        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(userEntity));
        var userDto = userServiceImpl.getById(1L);
        assertThat(userEntity.getFirstName()).isEqualTo(userDto.getFirstName());
    }

    // @Test
    void givenUserId_WhenFindUserById_ThenObtainEntityNotFoundException() {
        var userId = 1L;
        when(userRepository.findById(userId)).thenReturn(null);
        assertThatThrownBy(() -> userServiceImpl.getById(userId))
                .isInstanceOf(EntityNotFoundException.class).hasMessage("user not found");
    }


    @Test
    void givenAllUsers_WhenGetCountOfUsers_ThenObtainNumberOfUsers() {
        var userList = UserTestUtils.createUserList();
        when(userRepository.findAll())
                .thenReturn(userList);

        var usersDtoListFromDb = userServiceImpl.getAll();
        var userListDto = userMapper.mapToListDto(userList);

        assertEquals(usersDtoListFromDb, userListDto);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void givenUserEntity_WhenUpdateUser_ThenObtainUpdateUser() {
        var updateUserDto = UserTestUtils.updateValidUserDto();
        var userEntity = userMapper.updateUserDtoMapToEntity(updateUserDto);

        when(userRepository.findById(userEntity.getId()))
                .thenReturn(Optional.of(userEntity));
        var userDto = userServiceImpl.getById((userEntity.getId()));

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
        var updatedUser = userServiceImpl.update(userEntity.getId(), updateUserDto);

        assertThat(updatedUser.getId()).isEqualTo(userEntity.getId());
    }

    @Test
    void givenUserById_WhenDeleteUser_ThenDropUser() {
        var user = UserTestUtils.createValidUser();
        userServiceImpl.deleteById(user.getId());
        verify(userRepository, times(1))
                .deleteById(user.getId());

    }

    @Test
    void givenUserMail_WhenFindUserByMail_ThenObtainUser() {
        var user = UserTestUtils.createValidUser();

        when(userRepository.findByMail(user.getMail()))
                .thenReturn(java.util.Optional.of(user));

        var userDto = userMapper.mapToDto(user);

        assertThat(userServiceImpl.findByMail((user.getMail())))
                .isEqualTo(userDto);
    }

    @Test
    void givenUserMail_WhenFindUserByMail_ThenObtainEntityNotFoundException() {
        String mail = "ghjnbv@mail";

        when(userRepository.findByMail(mail)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userServiceImpl.findByMail(mail))
                .isInstanceOf(EntityNotFoundException.class).hasMessage("User doesn't exists");
    }
}