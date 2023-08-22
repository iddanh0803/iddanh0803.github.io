package vn.techmaster.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demo.dao.TodoDAO;
import vn.techmaster.demo.exception.ResourceNotFoundEx;
import vn.techmaster.demo.model.Todo;

import java.util.List;
import java.util.Random;

@Service
public class TodoService implements TodoServiceImpl{

    @Autowired
    private TodoDAO todoDAO;

    @Override
    public List<Todo> getTodos() {
        return todoDAO.findAll();
    }

    @Override
    public Todo getTodoByID(Integer id) {
        List<Todo> todoList = todoDAO.findAll();
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->{
                    throw new ResourceNotFoundEx("không tìm thấy todo");
                });
    }

    @Override
    public Todo createTodo(Todo request) {
        Random rd = new Random();
        Todo todo = new Todo();
        todo.setId(rd.nextInt(1000));
        todo.setTitle(request.getTitle());
        todoDAO.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Integer id, Todo request) {
        Todo todo = getTodoByID(id);
        todo.setTitle(request.getTitle());
        todo.setStatus(request.getStatus());
        return todo;
    }

    @Override
    public void deleteTodo(Integer id) {
        Todo todo = getTodoByID(id);
        todoDAO.delete(id);
    }
}
