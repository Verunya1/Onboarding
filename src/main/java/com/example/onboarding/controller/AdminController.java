package com.example.onboarding.controller;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.Post;
import com.example.onboarding.entity.Product;
import com.example.onboarding.entity.User;
import com.example.onboarding.service.CourseService;
import com.example.onboarding.service.PostService;
import com.example.onboarding.service.ProductService;
import com.example.onboarding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class AdminController {
    private final CourseService courseService;
    private final ProductService productService;
    private final PostService postService;
    private final UserService userService;

    @GetMapping("add-course")
    public String addCourse(Model model, Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("course", new Course());
        return "add_course.html";
    }

    @PostMapping("add-course-video")
    public String addCourseSubmit(@ModelAttribute Course course, MultipartFile vid, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        courseService.saveVideoCourse(course, vid);

        return "redirect:/course";
    }

    @PostMapping("add-course-presentation")
    public String addPresentationSubmit(@ModelAttribute Course course, MultipartFile pptx, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        courseService.savePresentationCourse(course, pptx);

        return "redirect:/course";
    }

    @GetMapping("add-post")
    public String addPost(Model model, Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("post", new Post());
        return "add_post";
    }

    @PostMapping("add-post")
    public String addPostSubmit(@ModelAttribute Post post, MultipartFile img, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        postService.savePost(post, img);

        return "redirect:/post";
    }

    @GetMapping("add-product")
    public String addProduct(Model model, Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("post", new Post());
        return "add_post";
    }

    @PostMapping("add-product")
    public String addProductSubmit(@ModelAttribute Product product, MultipartFile img, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        productService.saveProduct(product, img);

        return "redirect:/product";
    }

    @GetMapping("add-user")
    public String addUser(Model model, Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("add-user")
    public String addUserSubmit(@ModelAttribute User user, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        userService.add(user);

        return "redirect:/user";
    }

    @GetMapping("add-command")
    public String addCommand(Model model, Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("command", new User());
        return "add_command.html";
    }

    @PostMapping("add-command")
    public String addCommandSubmit(@ModelAttribute User user, Authentication authentication) throws IOException {
        if (!authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        userService.add(user);

        return "redirect:/command";
    }

//    @GetMapping("delete-command")
//    public String deleteCommand(Model model, Authentication authentication) {
//        if (!authentication.isAuthenticated()) {
//            return "redirect:/login";
//        }
//
//        model.addAttribute("command", new User());
//        return "delete_command.html";
//    }
//    @DeleteMapping("delete-command")
//    public String deleteCommandSubmit(@ModelAttribute User user, Authentication authentication) throws IOException {
//        if (!authentication.isAuthenticated()) {
//            return "redirect:/login";
//        }
//
//        userService.add(user);
//
//        return "redirect:/command";
//    }
}
