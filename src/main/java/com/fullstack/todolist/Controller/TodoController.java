package com.fullstack.todolist.Controller;

import com.fullstack.todolist.Model.Todo;
import com.fullstack.todolist.Service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return todoService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long Id) {
        return todoService.delete(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity getById(@RequestParam Long Id) {
        return todoService.getById(Id);
    }

}
