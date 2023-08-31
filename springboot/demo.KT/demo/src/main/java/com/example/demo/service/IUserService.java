package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.request.PasswordUpdateRequest;
import com.example.demo.request.UpsertUserRequest;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    User getUserById(Integer id);
    User updateUser(Integer id, UpsertUserRequest request);
    User createUser(UpsertUserRequest request);
    void deleteUser(Integer id);

    List<User> searchUserByName(String name);

    void changeAvatar(Integer id, UpsertUserRequest request);

    void updatePassword(Integer id, PasswordUpdateRequest request);

    String forgotPassword(Integer id);
}
