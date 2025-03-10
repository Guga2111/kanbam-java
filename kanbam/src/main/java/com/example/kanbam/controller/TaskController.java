package com.example.kanbam.controller;

import com.example.kanbam.entity.Task;
import com.example.kanbam.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    TaskService kanbamService;

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = kanbamService.getTasks();
        return new ResponseEntity(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@Valid @PathVariable Long id) {
        Task task = kanbamService.getTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/{boardId}")
    public ResponseEntity<Task> saveTask(@RequestBody Task task, @PathVariable Long boardId) {
        return new ResponseEntity<>(kanbamService.saveTask(task, boardId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @Valid @PathVariable Long id) {
        return new ResponseEntity<>(kanbamService.updateTask(task.getStatus(), task.getPriority(), id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@Valid @PathVariable Long id) {
        kanbamService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
