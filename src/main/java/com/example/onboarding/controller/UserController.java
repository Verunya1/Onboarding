package com.example.onboarding.controller;

import com.example.onboarding.entity.User;
import com.example.onboarding.service.CourseService;
import com.example.onboarding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final CourseService courseService;
    private final UserService userService;
//    @GetMapping("index")
//    public String index() {
//        return "index";
//    }
    @GetMapping
    public User get(@RequestParam Long id) { // подумать над integer/long
        return userService.get(id);
    }
    @PostMapping("login")
    public User login(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return userService.add(user);
    }



}
