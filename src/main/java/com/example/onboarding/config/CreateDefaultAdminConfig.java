package com.example.onboarding.config;

import com.example.onboarding.entity.Command;
import com.example.onboarding.entity.User;
import com.example.onboarding.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateDefaultAdminConfig {
    private final UserService userService;

    @PostConstruct
    public void createAdminCommand() {
        User user;

        try {
            user = userService.getByUsername("Admin");
        } catch (Exception e) {
            user = userService.addAdmin(
                    new User(0L,
                            new Command(0L,"techSupport","technological support"),
                            1000L,
                            "admin@admin.ru",
                            "Admin","admin","12345","ADMIN"

                    )
            );
        }
    }
}
