package com.example.security.controller;

import com.example.security.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class WebController {
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @GetMapping("/")
    public String getHome(){
        return "Home page";
    }

    @GetMapping("/profile")
    public String getProfile(){
        return "Profile page";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Admin page";
    }

    @GetMapping("/get-info")
    public ResponseEntity<?> getInfo(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }

    @GetMapping("/get-info1")
    public ResponseEntity<?> getInfo1(Principal principal){
        return ResponseEntity.ok(principal);
    }
    @GetMapping("/get-info2")
    public ResponseEntity<?> getInfo2(Authentication authentication){
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/get-info3")
    public ResponseEntity<?> getInfo2(){
        Authentication authentication = authenticationFacade.getAuthentication();
        return ResponseEntity.ok(authentication);
    }
}
