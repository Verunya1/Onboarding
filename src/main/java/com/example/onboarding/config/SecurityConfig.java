package com.example.onboarding.config;



import com.example.onboarding.service.DBUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor

public class SecurityConfig {
    private final DBUserDetailsService dbUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(dbUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsManager())
                .passwordEncoder(passwordEncoder())
                .and().build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().and()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "api/user").authenticated()
                        .requestMatchers("api/user/login").permitAll()
                        .requestMatchers("api/user").hasAuthority("ADMIN")
                        .requestMatchers("api/user/all").hasAuthority("ADMIN")

                        .requestMatchers(HttpMethod.GET, "api/course").authenticated()
                        .requestMatchers(HttpMethod.GET, "api/course/v1").authenticated()
                        .requestMatchers(HttpMethod.POST, "api/course/salary").authenticated()

                        .requestMatchers(HttpMethod.GET, "api/product").authenticated()
                        .requestMatchers(HttpMethod.GET, "api/product/v1").authenticated()
                        .requestMatchers(HttpMethod.POST, "api/product/buy").authenticated()

                        .requestMatchers(HttpMethod.GET, "api/command").authenticated()
                        .requestMatchers(HttpMethod.POST, "api/command").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/command").hasAuthority("ADMIN")

                        .requestMatchers(HttpMethod.GET, "api/book").permitAll()
                        .requestMatchers(HttpMethod.POST, "api/book").authenticated()
                        .requestMatchers("api/book/all").permitAll()
                        .requestMatchers("api/book/all/moderate").hasAuthority("ADMIN")
                        .requestMatchers("api/book/approve").hasAuthority("ADMIN")

                        .requestMatchers("**").authenticated()
                )

                .csrf().disable()
                .authenticationManager(authenticationManager(httpSecurity))
                .build();
    }
}
