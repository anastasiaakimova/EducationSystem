package by.akimova.educationSystem.mappers;

import by.akimova.educationSystem.model.User;
import by.akimova.educationSystem.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapToDto(User user);

    List<UserDto> mapToListDto(List<User> users);

    User mapToEntity(UserDto userDto);
}
