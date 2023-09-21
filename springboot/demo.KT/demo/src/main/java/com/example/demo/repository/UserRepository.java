package com.example.demo.repository;

import com.example.demo.dto.AvatarDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.request.UpsertUserRequest;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getAllUser();
    User getUserById(Integer id );
    List<User> findByNameContainingIgnoreCase(String name);
    User createUser(UpsertUserRequest upsertUserRequest);
    User updateUser(Integer id, UserDto user  );
    boolean deleteUser(Integer id);
    User changeAvatar(Integer id, AvatarDto avatarDto);
}
