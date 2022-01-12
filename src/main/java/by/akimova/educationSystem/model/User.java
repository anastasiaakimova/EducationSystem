package by.akimova.educationSystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/*****************************************************************************************
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    private Long id;
    @Column(name = "first_name", length = 200, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;
    @Column(name = "mail", length = 200, nullable = false)
    private String mail;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "role")
    private Role role;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "registered_time")
    private LocalDateTime registeredTime;
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}