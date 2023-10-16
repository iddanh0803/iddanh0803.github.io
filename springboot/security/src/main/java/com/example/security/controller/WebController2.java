package com.example.security.controller;

import com.example.security.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController2 {
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('Admin') or  hasAuthority('Sale')")
    public String getDashboard(){
        return "dashboard";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUsers() {
        return "users";
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateUser(@PathVariable("id") Long id) {
        return "detail-user";
    }

    @GetMapping("/categories")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getCategories() {
        return "category";
    }

    @PutMapping("/categories/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateCategory(@PathVariable("id") Long id) {
        return "detail-category";
    }

    @GetMapping("/product")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('SALE')")
    public String getProduct() {
        return "product";
    }

    @PutMapping("/product")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('SALE')")
    public String updateProfile() {
        return "detail-product";
    }

    @GetMapping("/brands")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getBrands() {
        return "brands";
    }

    @PostMapping("/brands")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String createBrand() {
        return "create-brand";
    }

    @PutMapping("/brands/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateBrand(@PathVariable("id") Long id) {
        return "detail-brand";
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getOrders() {
        return "order";
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String createOrder() {
        return "create-order";
    }

    @GetMapping("/posts")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String getPosts() {
        return "post";
    }

    @PostMapping("/posts")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String createPost() {
        return "create-post";
    }

    @PutMapping("/posts/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String updatePost(@PathVariable("id") Long id) {
        return "detail-post";
    }

    @DeleteMapping("/posts/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('USER')")
    public String getProfile() {
        return "profile";
    }
}
