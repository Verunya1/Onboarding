package com.example.onboarding.repository;


import com.example.onboarding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> getAllByUserId(Long userId); // или это лучше в команду запихнуть


}