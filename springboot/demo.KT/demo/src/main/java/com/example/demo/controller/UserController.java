package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.PasswordUpdateRequest;
import com.example.demo.request.UpsertUserRequest;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class UserController {

    private final IUserService iUserService;
    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userRepository.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/api/v1/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        User user = userRepository.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/api/v1/search")
    public List<User> searchUser(@RequestParam String name){
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<?> createUser(@RequestBody UpsertUserRequest request){
        User user = userRepository.createUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/users/{id}/forgot-password")
    public String forgotPassword(@PathVariable Integer id ){
        return iUserService.forgotPassword(id);
    }

    @PutMapping("/api/v1/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UpsertUserRequest request){
        User user = userRepository.updateUser(id,request);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/api/v1/users/{id}/update-avatar")
    public void changeAvatar(@PathVariable Integer id, @RequestBody UpsertUserRequest request){
        userRepository.changeAvatar(id,request);
    }

    @PutMapping("/api/v1/users/{id}/update-password")
    public void updatePassword(@PathVariable Integer id, @RequestBody PasswordUpdateRequest request){
        iUserService.updatePassword(id,request);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteUser(id);
    }
}
