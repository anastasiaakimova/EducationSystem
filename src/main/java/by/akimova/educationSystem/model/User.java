package by.akimova.educationSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/*****************************************************************************************
 * It is a model of a simple user.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Data
@Entity
@Table(name = "app_user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "registered_time")
    private LocalDateTime registeredTime;
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}