package com.example.onboarding.controller;

import com.example.onboarding.entity.Course;
import com.example.onboarding.entity.Product;
import com.example.onboarding.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public Product get(@RequestParam Long id) {
        return productService.getProductByID(id);
    }

    @GetMapping("all")
    public List<Product> getAll() {
        return productService.getAll();
    }
}
