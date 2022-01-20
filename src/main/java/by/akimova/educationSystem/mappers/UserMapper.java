package by.akimova.educationSystem.mappers;

import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.CreateUserDto;
import by.akimova.educationSystem.service.dto.UpdateUserDto;
import by.akimova.educationSystem.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Mapper(componentModel = "spring")
@Component("userMapper")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapToDto(User user);

    User createUserDtoMapToEntity(CreateUserDto createUserDto);

    User updateUserDtoMapToEntity(UpdateUserDto updateUserDto);

    List<UserDto> mapToListDto(List<User> users);

    List<User> mapDtoToEntityList(List<UserDto> users);

}
