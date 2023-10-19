package com.example.demosecurity2.repository;

import com.example.demosecurity2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
   Optional<User> findByEmail(String email);
}
