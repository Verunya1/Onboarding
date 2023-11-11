package com.example.onboarding.repository;

import com.example.onboarding.entity.Command;
import com.example.onboarding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Long> {
//    List<Command> getAllByCommandId(Long commandId);
    List<User> getAllUsersByCommandId(Long commandId);
}
