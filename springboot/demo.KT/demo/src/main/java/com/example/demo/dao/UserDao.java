package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();

    Optional<User> findById(Integer id);
    User save(User user);
    void delete(Integer id);

    List<User> findByName(String name);
}
