package com.example.onboarding.controller;

import com.example.onboarding.entity.Course;
import com.example.onboarding.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;
//    private final

    @GetMapping
    public Course get(@RequestParam Long id) {
        return courseService.getCourseByID(id);
    }

    @GetMapping("all")
    public List<Course> getAll() {
        return courseService.getAll();
    }

//    @PostMapping
//    public Course create(@RequestBody Course course) {
//        return courseService.sa(book);
//    }

//    @GetMapping("all/moderate")
//    public List<Course> getAllModerate() {
//        return bookService.getAllNotApproved();
//    }
//
//    @PatchMapping("approve")
//    public Book approve(@RequestParam Integer id) {
//        return bookService.approve(id);
//    }
}
