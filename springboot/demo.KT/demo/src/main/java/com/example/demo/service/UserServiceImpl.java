package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.PasswordUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements IUserService{
   @Autowired
   private UserRepository userRepository;

    @Override
    public void updatePassword(Integer id, PasswordUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        if (!user.getPassword().equals(request.getOldPassword())){
            throw new IllegalArgumentException("Incorrect old passwword");
        }
        if (user.getPassword().equals(request.getNewPassword())){
            throw new IllegalArgumentException("New password must be different from old password");
        }
        user.setPassword(request.getNewPassword());
    }

    @Override
    public String forgotPassword(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        String newPassword = generateRandomPassword();
        user.setPassword(newPassword);
        return newPassword;
    }

    private String generateRandomPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 8;
        Random random = new Random();
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            newPassword.append(characters.charAt(index));
        }

        return newPassword.toString();
    }
}
