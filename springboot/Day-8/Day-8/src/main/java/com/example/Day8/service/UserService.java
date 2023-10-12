package com.example.Day8.service;

import com.example.Day8.dto.UserDto;
import com.example.Day8.entity.User;
import com.example.Day8.repository.UserRepository;
import com.example.Day8.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<UserDto> findAll(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        List<User> userList = userRepository.findAll();

    }

    public User createUser(UpsertUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAvatar(request.getAvatar());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRoles(request.getRoles());
        userRepository.save(user);
        return user;
    }

    public UserDto getUserById(Integer id) {

        User user =  userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Không tìm thấy user"));
        return new UserDto(user);
    }

    public UserDto updateUser(UpsertUserRequest request, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy user"));
        user.setName(request.getName());
        user.setAvatar(request.getAvatar());
        user.setRoles(request.getRoles());
        userRepository.save(user);
        return new UserDto(user);
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Không tìm thấy user"));
    }
}
