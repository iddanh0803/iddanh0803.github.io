package com.example.demothymeleafspringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/profile").hasRole("USER")
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated()
                                .anyRequest().authenticated()
                );
        http.formLogin(login -> login
                .loginPage("/login")
                .loginProcessingUrl("/login-process")
                .usernameParameter("email")
                .passwordParameter("pass")
                .defaultSuccessUrl("/", true)
                .permitAll()
        );
        http.logout(logout -> logout
                .logoutSuccessUrl("/")
                .deleteCookies("JNADJFN")
                .invalidateHttpSession(true)
                .permitAll()
        );
        return http.build();
    }
}