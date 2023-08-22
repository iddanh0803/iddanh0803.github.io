package vn.techmaster.demo.service;

import vn.techmaster.demo.model.Todo;

import java.util.List;

public interface TodoServiceImpl {
    List<Todo> getTodos();

    Todo getTodoByID(Integer id);

    Todo createTodo(Todo request);

    Todo updateTodo(Integer id, Todo request);

    void deleteTodo(Integer id);
}
