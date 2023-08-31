package vn.techmaster.demo.dao;

import vn.techmaster.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> finAll();

    Optional<User> findById(Integer id);
}
