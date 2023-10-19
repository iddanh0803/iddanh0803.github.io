package com.example.demosecurity2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailService userDetailService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserDetailService userDetailService, PasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/profile").hasRole("USER")
                                .requestMatchers("/admin").hasRole("ADMIN")
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
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }
}
