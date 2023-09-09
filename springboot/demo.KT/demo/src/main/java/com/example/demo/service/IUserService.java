package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.request.PasswordUpdateRequest;
import com.example.demo.request.UpsertUserRequest;

import java.util.List;

public interface IUserService {
    void updatePassword(Integer id, PasswordUpdateRequest request);

    String forgotPassword(Integer id);
}
