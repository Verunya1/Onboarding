package com.example.onboarding.controller;

import com.example.onboarding.entity.*;
import com.example.onboarding.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class OnboardingController {
    private final CommandService commandService;
    private final ProductService productService;
    private final CourseService courseService;
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/staff")
    public String staff(@RequestParam Long id, Model model) {
        Command command = commandService.getCommandByID(id);
        List<User> users = commandService.getAllUsers(id);

        model.addAttribute("command", command);
        model.addAttribute("user", users);

        return "staff";
    }

    @GetMapping("/command")
    public String commands(Model model) {
        List<Command> commands = commandService.getAllCommand();
        model.addAttribute("commands", commands);
        return "command";
    }
    @GetMapping("/product")
    public String products(Model model) {
        List<Product> products = productService.getAll();
        List<ProductImage> images = new ArrayList<>();
        List<ProductImage> productImages = new ArrayList<>();

        products.forEach(product ->
            productImages.add(productService.getImages(product.getId()).get(0)) );
        model.addAttribute("product", products);
        return "product";
    }
    @GetMapping("/course")
    public String courses(Model model) {
        List<Course> courses = courseService.getAll();
        List<CourseVideo> videos = new ArrayList<>();
        List<CoursePresentation> presentations = new ArrayList<>();

        courses.forEach(course -> {
            videos.add(courseService.getAllVideos(course.getId()).get(0));
            presentations.add(courseService.getAllPresentation(course.getId()).get(0));
        });

//        users.addAll(realties.stream().map(r -> userService.get(r.getUserId())).collect(Collectors.toList()));
        model.addAttribute("videos", videos);
        model.addAttribute("courses", courses);
        model.addAttribute("presentations", presentations);
        return "course";
    }
}
