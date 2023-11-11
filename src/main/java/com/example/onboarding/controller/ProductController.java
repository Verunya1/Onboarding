package com.example.onboarding.controller;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.Product;
import com.example.onboarding.entity.User;
import com.example.onboarding.service.ProductService;
import com.example.onboarding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/v1")
    public Product get(@RequestParam Long id) {
        return productService.getProductByID(id);
    }

    @GetMapping("/buy")
    public String buyProduct(@RequestParam("id") Long id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        userService.buyProductById(user, id);
        return "redirect:/product";
    }
}
