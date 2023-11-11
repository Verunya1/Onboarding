package com.example.onboarding.service;

import com.example.onboarding.entity.User;
import com.example.onboarding.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CourseService courseService;
    private final PostService postService;
    private final CommandService commandService;

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setMoney(0L);
        return userRepository.save(user);
    }
// public User add(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole("USER");
//        return userRepository.save(user);
//    }
//
//    public User addModer(User user) {
//        System.out.println(user.getPassword());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        System.out.println(user.getPassword());
//        user.setRole("MODER");
//        return userRepository.save(user);
//    }
//
//    public Boolean authorise(User user, HttpServletRequest req) {
//        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//
//        Authentication auth = authenticationManager.authenticate(authReq);
//
//        if(!auth.isAuthenticated()) {
//            return false;
//        }
//
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
//        HttpSession session = req.getSession(true);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
//
//        return true;
//    }
    public Boolean authorise(User user, HttpServletRequest req) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication auth = authenticationManager.authenticate(authReq);

        if (!auth.isAuthenticated()) {
            return false;
        }

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = req.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);

        return true;
    }

    public void buyRealtyById(User user, Long realtyId) {
        Realty realty = realtiesService.getRealtyByID(realtyId);
        if (user.getMoney() < realty.getPrice()) {
            return;
        }
        user.setMoney(user.getMoney() - realty.getPrice());

        User owner = get(realty.getUserId());

        owner.setMoney(owner.getMoney() + realty.getPrice());

        realtiesService.deleteRealty(realtyId);
    }
}
