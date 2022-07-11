package com.fullstack.todolist.Service;

import com.fullstack.todolist.Model.Status;
import com.fullstack.todolist.Repository.StatusRepo;
import com.fullstack.todolist.ResponseHandler.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private final StatusRepo statusRepo;

    public StatusService(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }


    //Save a record also update if id is same
    public ResponseEntity<Object> save(Status status) {
        try {
            statusRepo.save(status);
            return (Response.generateResponse("success", HttpStatus.OK, status));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> getById(Long id) {
        try {
            Optional<Status> statusOptional = statusRepo.findById(id);
            if (statusOptional.isPresent())
                return (Response.generateResponse("success", HttpStatus.OK, statusOptional));
            else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        try {
            Optional<Status> statusOptional = statusRepo.findById(id);
            if (statusOptional.isPresent()) {
                statusRepo.delete(statusRepo.findById(id).get());
                return (Response.generateResponse("success", HttpStatus.OK, statusOptional));
            } else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try {
            List<Status> statusList = statusRepo.findAll();
            if (!statusList.isEmpty())
                return (Response.generateResponse("success", HttpStatus.OK, statusList));
            else
                return (Response.generateResponse("Not Found", HttpStatus.NOT_FOUND, null));
        } catch (Exception e) {
            return (Response.generateResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage()));
        }
    }
}
