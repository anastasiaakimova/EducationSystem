package by.akimova.educationSystem.repository;

import by.akimova.educationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*****************************************************************************************
 * Repository interface for class {@link User}.
 *
 * @author Akimova Anastasia
 * @version 1.0
 *
 * Copyright (c) 2022.
 ****************************************************************************************/

@Repository("userRepository")
public interface UserRepo extends JpaRepository<User, String> {
    void deleteUserById(Long id);

    Optional<User> findByMail(String mail);

    User findUserById(Long id);
}