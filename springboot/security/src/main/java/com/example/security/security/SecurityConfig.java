package com.example.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] patterns = {"/css", "/aaa/**", "/bbb/**"};
        http
        .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()
                .requestMatchers(patterns).permitAll()
                .requestMatchers("/profile", "/api/user/**").hasRole("USER")
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/author").hasAnyRole("ADMIN", "AUTHOR")
                .requestMatchers("/book").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/user").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .anyRequest().authenticated()
        );
        http.formLogin(login -> login
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
