package com.example.demosecurity2.controller;

import com.example.demosecurity2.dto.UserDto;
import com.example.demosecurity2.model.User;
import com.example.demosecurity2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/api/v1/auth/register")
    public void createUser(@RequestBody UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        List<User>userList = userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(userDto.getEmail()))
                throw new UsernameNotFoundException("Email already in use");
            else user.setEmail(userDto.getEmail());
        }
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}
