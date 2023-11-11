package com.example.onboarding.service;

import com.example.onboarding.entity.Command;
import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.CourseVideo;
import com.example.onboarding.entity.User;
import com.example.onboarding.repository.CommandRepository;
import com.example.onboarding.repository.CourseRepository;
import com.example.onboarding.repository.CourseVideoRepository;
import com.example.onboarding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandRepository commandRepository;
    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getAllUsers(Long id) {
        return commandRepository.getAllUsersByCommandId(id);
    }
    public List<Command> getAllCommand() {
        return commandRepository.findAll();
    }
    public Command saveCommand(Command command) {
        return commandRepository.save(command);
    }

    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }

    public Command getCommandByID(Long id) {
        return commandRepository.findById(id).orElseThrow();
    }
}
