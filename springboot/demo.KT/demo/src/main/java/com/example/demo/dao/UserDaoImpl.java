package com.example.demo.dao;

import com.example.demo.database.UserDB;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> findAll() {
        return UserDB.userList;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return UserDB.userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public User save(User user) {
        user.setId(createId());
        UserDB.userList.add(user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        UserDB.userList.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public List<User> findByName(String name) {
        return UserDB.userList.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private Integer createId() {
        List<User> courseList = UserDB.userList;
        return courseList.stream()
                .map(User::getId)
                .mapToInt(Integer::valueOf)
                .max().orElse(0) + 1;
    }
}
