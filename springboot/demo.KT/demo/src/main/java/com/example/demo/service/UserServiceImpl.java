package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.request.PasswordUpdateRequest;
import com.example.demo.request.UpsertUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements IUserService{
    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user"));
    }

    @Override
    public User updateUser(Integer id, UpsertUserRequest request) {
        User user = userDao.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        return user;
    }

    @Override
    public User createUser(UpsertUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setAvatar(request.getAvatar());

        return userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        userDao.delete(id);
    }

    @Override
    public List<User> searchUserByName(String name) {
        if (name.trim().length()==0){
            throw new BadRequestException("name không được để trống");
        }
        return userDao.findByName(name);
    }

    @Override
    public void changeAvatar(Integer id, UpsertUserRequest request) {
        User user = userDao.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        user.setAvatar(request.getAvatar());

    }

    @Override
    public void updatePassword(Integer id, PasswordUpdateRequest request) {
        User user = userDao.findById(id)
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
        User user = userDao.findById(id)
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
