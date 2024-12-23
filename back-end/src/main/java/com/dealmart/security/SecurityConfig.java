package com.dealmart.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/users/**", "/products/**", "/carts/**", "/ratings/**").permitAll()  // Allow all requests to /users without authentication
                .anyRequest().authenticated());  // Require authentication for other paths

        return http.build();
    }
}
