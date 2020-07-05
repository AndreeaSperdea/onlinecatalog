package com.andreea.onlinecatalog.repository;

import com.andreea.onlinecatalog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);    //optional inseamna ca ne returneaza un singur user
    Optional<User> findByEmailAddress(String email);
}
