package vn.techmaster.demo.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.demo.database.TodoDB;
import vn.techmaster.demo.model.Todo;

import java.util.List;

@Repository
public class TodoDAO implements TodoDAOImpl{

    @Override
    public List<Todo> findAll() {
        return TodoDB.todoList;
    }

    @Override
    public void save(Todo todo) {
        TodoDB.todoList.add(todo);
    }

    @Override
    public void delete(Integer id) {
        TodoDB.todoList.removeIf(todo -> todo.getId().equals(id));
    }
}
