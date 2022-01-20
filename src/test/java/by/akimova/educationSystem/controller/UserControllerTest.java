package by.akimova.educationSystem.controller;

import by.akimova.educationSystem.service.UserService;
import by.akimova.educationSystem.service.impl.UserTestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*****************************************************************************************
 * Testing class for {@link UserController}
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@SpringBootTest
@AutoConfigureMockMvc

@RunWith(SpringRunner.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


      @Test
    void givenUserEntity_WhenSaveUser_ThenObtainSaveUser() throws Exception {
          var createUserDto = UserTestUtils.createValidUserDto();

        given(userService.save(createUserDto))
                .willAnswer((invocation) -> invocation.getArgument(0));


        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(createUserDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void givenAllUsers_WhenGetCountOfUsers_ThenObtainNumberOfUsers() throws Exception {
        var users = UserTestUtils.createUserDtoList();
        when(userService.getAll()).thenReturn(users);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void givenUserId_WhenFindUserById_ThenObtainUser() throws Exception {
        var user = UserTestUtils.validUserDto();
        when(userService.getById(user.getId())).thenReturn(user);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService).getById(user.getId());
    }

    @Test
    void givenUserMail_WhenFindUserByMail_ThenObtainUser() throws Exception {
        var user = UserTestUtils.validUserDto();

        when(userService.findByMail(user.getMail())).thenReturn(user);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/mail/" + user.getMail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenUserEntity_WhenUpdateUser_ThenObtainUpdateUser() throws Exception {
        var user = UserTestUtils.validUserDto();
        var updateUserDto = UserTestUtils.updateValidUserDto();

        given(userService.update(user.getId(), updateUserDto))
                .willAnswer((invocation) -> invocation.getArgument(0));


        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/users/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void givenUserById_WhenDeleteUser_ThenDropUser() throws Exception {
        var userDto = UserTestUtils.validUserDto();

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/users/" + userDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}