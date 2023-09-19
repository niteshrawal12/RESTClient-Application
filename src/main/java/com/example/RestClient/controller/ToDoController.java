package com.example.RestClient.controller;
import com.example.RestClient.model.Todo;
import com.example.RestClient.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/todos")
public class ToDoController {
    private TodoService service;
    public ToDoController(TodoService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getSingleTodo(@PathVariable int id) {
        try {
            Todo todo = service.getTodo(id);
            return ResponseEntity.ok(todo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/")
    public List<Todo> getTodos(){
        return service.getTodos();
    }
    @PostMapping("/")
    public Todo createTodo(@RequestBody Todo todo){
        return service.createPost(todo);
    }
}
