package com.example.demoJwtSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    
    /*@Bean
    SecurityFilterChain filterchain(HttpSecurity http, AuthenticationManager authManager) {
        
        return http
                .csrf().disable()
    }*/
}
