package com.example.onboarding.controller;

import com.example.onboarding.entity.Command;
import com.example.onboarding.entity.User;
import com.example.onboarding.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/command")
public class CommandController {
    private final CommandService commandService;

    @GetMapping()
    public List<Command> getAll() {
        return commandService.getAllCommand();
    }

    @PostMapping
    public Command create(@RequestBody Command command) {
        return commandService.saveCommand(command);
    }
    @DeleteMapping
    public void delete(@RequestBody Long id) {
        commandService.deleteCommand(id);
    }


//    @GetMapping("/advertisement")
//    public String advertisementInfo(@RequestParam("id") Long id, Model model, Authentication authentication) {
//        Realty realty = realtyService.getRealtyByID(id);
//        User owner = userService.get(realty.getUserId());
//        if (authentication != null) {
//            User user = (User) authentication.getPrincipal();
//            model.addAttribute("user", user);
//        }
//        List<RealtyImage> realtyImages = realtyService.getAllImages(id);
//        model.addAttribute("advertisement", realty);
//        model.addAttribute("images", realtyImages);
//        model.addAttribute("owner", owner);
//        return "advertisement_info";
//    }
//    @GetMapping("all/moderate")
//    public List<Book> getAllModerate() {
//        return bookService.getAllNotApproved();
//    }
//
//    @PatchMapping("approve")
//    public Book approve(@RequestParam Integer id) {
//        return bookService.approve(id);
//    }
}
