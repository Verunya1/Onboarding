package com.example.onboarding.controller;

import com.example.onboarding.entity.User;
import com.example.onboarding.service.CommandService;
import com.example.onboarding.service.CourseService;
import com.example.onboarding.service.PostService;
import com.example.onboarding.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("info")
public class InfoController {
    private final CommandService commandService;
    private final ProductService productService;
    private final CourseService courseService;
    private final PostService postService;

    @GetMapping("/staff")
    public List<User> staff(@RequestParam("id") Long id, Model model) {
        return commandService.getAllUsers(id);
    }
//    @GetMapping("/book")
//    public String book(@RequestParam Integer id, Model model) {
//        Book book = bookService.get(id);
//        Author author = authorService.get(book.getAuthorId());
//        List<BookImage> img = bookService.getAllImages(id);
//
//        model.addAttribute("book", book);
//        model.addAttribute("img", img);
//        model.addAttribute("author", author);
//
//        return "book";
//    }

    @GetMapping("/staff")
    public List<User> listUser(@RequestParam("id") Long id, Model model) {
        return commandService.getAllUsers(id);
    }

}
