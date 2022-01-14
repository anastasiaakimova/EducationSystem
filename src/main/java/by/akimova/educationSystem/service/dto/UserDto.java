package by.akimova.educationSystem.service.dto;

import by.akimova.educationSystem.model.Gender;
import by.akimova.educationSystem.model.Role;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/
@Data
//@ApiModel(value = "UserModel", description = "Model who represents an user entity")
public class UserDto {

    private Long id;
  //  @ApiModelProperty(value = "User's first name", required = true)
    private String firstName;
  //  @ApiModelProperty(value = "User's last name", required = true)
    private String lastName;
  //  @ApiModelProperty(value = "User's email", required = true)
    private String mail;
 //   @ApiModelProperty(value = "User's password", required = true)
    private String password;
   // @ApiModelProperty(value = "User's gender", required = true)
    private Gender gender;
   // @ApiModelProperty(value = "User's phone number", required = true)
    private String phoneNumber;
   // @ApiModelProperty(value = "User's role", required = true)
    private Role role;
   // @ApiModelProperty(value = "User's date of birthday", required = true)
    private LocalDateTime birthDate;
   // @ApiModelProperty(value = "User's date of registration", required = true)
    private LocalDateTime registeredTime;
  //  @ApiModelProperty(value = "User's date of last account update", required = true)
    private LocalDateTime updatedTime;

}
