package com.example.onboarding.controller;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.User;
import com.example.onboarding.service.CourseService;
import com.example.onboarding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;

    @GetMapping()
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/v1")
    public Course get(@RequestParam Long id) {
        return courseService.getCourseByID(id);
    }


    @GetMapping("/salary")
    public String salaryCourse(@RequestParam("id") Long id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        userService.salaryCourseById(user, id);
        return "redirect:/course"; // понять куда редиректить
    }

}
