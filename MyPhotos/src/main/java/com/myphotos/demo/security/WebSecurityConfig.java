package com.myphotos.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    
    @Bean
    SecurityFilterChain filterchain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        
        return http
                .csrf().disable()
                .authorizeHttpRequests()    // le richieste autorizzate sono
                .anyRequest()   // qualsiasi richiesta (http)
                .authenticated()    // che sia autenticata
                .and()  // e
                .httpBasic()    // il tipo di autenticazione sarà basica (username, password)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // le sessioni saranno create senza stato
                .and()
                .build();   // si construisce il "SecurityFilterChain"
    }
    
    @Bean
    UserDetailsService userDetailsService() {
        
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  // "manager" creerà gli user e li caricherà in memoria
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))    // come password, si assegna "admin" che pero verrà criptata
                .roles()
                .build());      // si construisce l'oggetto "User"
        
        return manager;
    }
    
    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())       // si richiama il metodo "userDetailsService"
                .passwordEncoder(passwordEncoder())     // si richiama il metodo "passwordEncoder"
                .and()
                .build();   // si costruisce l'oggetto "AuthenticationManager"
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();     // si ottiene un "criptatore"
    }
    
}
