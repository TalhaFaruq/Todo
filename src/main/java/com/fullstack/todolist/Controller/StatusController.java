package com.fullstack.todolist.Controller;

import com.fullstack.todolist.Model.Status;
import com.fullstack.todolist.Service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }


    @GetMapping("/list")
    public ResponseEntity list() {
        return statusService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Status status) {
        return statusService.save(status);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Status status) {
        return statusService.save(status);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long Id) {
        return statusService.delete(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity getById(@RequestParam Long Id) {
        return statusService.getById(Id);
    }

}
