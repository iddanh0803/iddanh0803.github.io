package com.example.demothymeleafspringsecurity.controller;

import com.example.demothymeleafspringsecurity.security.IsAdmin;
import com.example.demothymeleafspringsecurity.security.IsUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
@Controller
public class WebController {
    @GetMapping("/")
    public String getHome(){
        return "index";
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @IsUser
    @GetMapping("/profile")
    public String getProfile(){
        return "profile";
    }

    @IsAdmin
    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
