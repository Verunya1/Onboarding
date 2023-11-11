package com.example.onboarding.controller;

import com.example.onboarding.entity.User;
import com.example.onboarding.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class AuthorisationController {
    private final UserService userService;

//    @GetMapping("register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "registration";
//    }

//    @PostMapping("register")
//    public String registerSubmit(@ModelAttribute User user, HttpServletRequest req) {
//        userService.add(user);
//
//        return "redirect:/login";
//    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("login")
    public String loginSubmit(@ModelAttribute User user, HttpServletRequest req) {
        if (!userService.authorise(user, req)) {
            return "redirect:/login";
        }
//        userService.authorise(user, req);

        return "redirect:/index";
    }
}
