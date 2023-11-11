//package com.example.onboarding.controller;
//
//import app.realtyagency.entity.Realty;
//import app.realtyagency.entity.RealtyImage;
//import app.realtyagency.entity.User;
//import app.realtyagency.service.RealtiesService;
//import app.realtyagency.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@RequiredArgsConstructor
//
//public class OnboardingController {
//
//    private final RealtiesService realtyService;
//    private final UserService userService;
//
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
//
//
//}
