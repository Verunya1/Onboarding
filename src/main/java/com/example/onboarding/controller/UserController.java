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
//    @GetMapping("/index")
//    public String getAdvertisement(Model model, Authentication authentication) {
//        if (authentication != null) {
//            User user = (User) authentication.getPrincipal();
//            model.addAttribute("user", user);
//        }
//        List<Realty> realties = realtyService.getAll();
//        List<User> users = new ArrayList<>();
//        List<RealtyImage> realtyImages = new ArrayList<>();
//        realties.forEach(realty -> {
//            users.add(userService.get(realty.getUserId()));
//            realtyImages.add(realtyService.getAllImages(realty.getId()).get(0));
//        });
//        users.addAll(realties.stream().map(r -> userService.get(r.getUserId())).collect(Collectors.toList()));
//        model.addAttribute("ads", realties);
//        model.addAttribute("users", users);
//        model.addAttribute("images", realtyImages);
//        return "ads";
//    }
//
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
//
//    @GetMapping("/advertisement/new")
//    public String newAdvertisement(@ModelAttribute("advertisement") Realty realty, Authentication authentication, Model model) {
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("user", user);
//        return "add_advertisement";
//    }
//
//    @PostMapping("/advertisement")
//    public String createAdvertisement(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
//                                      @RequestParam("file3") MultipartFile file3, @ModelAttribute("advertisement") Realty realty, Authentication authentication)
//            throws IOException {
//
//        User user = (User) authentication.getPrincipal();
//        realty.setUserId(user.getId());
//        realtyService.saveRealty(realty, file1, file2, file3);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/advertisement/delete")
//    public String deleteAdvertisement(@RequestParam("id") Long id) {
//        realtyService.deleteRealty(id);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/advertisement/buy")
//    public String buyAdvertisement(@RequestParam("id") Long id, Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        userService.buyRealtyById(user, id);
//        return "redirect:/index";
//    }


}
