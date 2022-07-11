package com.fullstack.todolist.Service;

import com.fullstack.todolist.Model.Todo;
import com.fullstack.todolist.Repository.TodoRepo;
import com.fullstack.todolist.ResponseHandler.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    //Save a record also update if id is same
    public ResponseEntity<Object> save(Todo todo) {
        try {
            todoRepo.save(todo);
            return (Response.generateResponse("success", HttpStatus.OK, todo));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> getById(Long id) {
        try {
            Optional<Todo> todoOptional = todoRepo.findById(id);
            if (todoOptional.isPresent())
                return (Response.generateResponse("success", HttpStatus.OK, todoOptional));
            else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        try {
            Optional<Todo> todoOptional = todoRepo.findById(id);
            if (todoOptional.isPresent()) {
                if (!todoOptional.get().getStatus().equals(null))
                    todoOptional.get().getStatus().equals(null);
                todoRepo.delete(todoRepo.findById(id).get());
                return (Response.generateResponse("success", HttpStatus.OK, todoOptional));
            } else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try {
            List<Todo> todoList = todoRepo.findAll();
            if (!todoList.isEmpty())
                return (Response.generateResponse("success", HttpStatus.OK, todoList));
            else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }
}
