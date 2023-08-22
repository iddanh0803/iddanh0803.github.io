package vn.techmaster.demo.dao;

import vn.techmaster.demo.model.Todo;

import java.util.List;

public interface TodoDAOImpl {
    List<Todo> findAll();

    void save(Todo todo);

    void delete(Integer id);
}
