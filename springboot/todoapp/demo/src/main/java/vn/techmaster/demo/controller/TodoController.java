package vn.techmaster.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demo.model.Todo;
import vn.techmaster.demo.response.ErrorResponse;
import vn.techmaster.demo.service.TodoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;

    //Lấy danh sách todo
    @GetMapping
    public ResponseEntity<?> getTodos(){
        return ResponseEntity.ok(todoService.getTodos());
    }

    // Lấy chi tiết theo id
    @GetMapping("/id")
    public ResponseEntity<?> getTodoByID(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(todoService.getTodoByID(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage()),
                    HttpStatus.NOT_FOUND
            );
        }
    }
    //Tạo mới todo
    @PostMapping
    public ResponseEntity<?> createTodo(@Valid @RequestBody Todo request){
        try {
            return new  ResponseEntity<>(todoService.createTodo(request), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage()),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    //Cập nhật todo
    @PostMapping("/id")
    public Todo updateTodo(@PathVariable Integer id,@Valid @RequestBody Todo request){
        return todoService.updateTodo(id, request);
    }

    // Xóa todo

    public void deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
    }
}
