package org.crudtask.controller;

import org.crudtask.entity.Task;
import org.crudtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/saveTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task taskById = taskService.getTaskById(id).orElseThrow(null);
        //return new ResponseEntity<>(taskById, HttpStatus.OK);
        return ResponseEntity.ok(taskById);
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task taskById = taskService.getTaskById(id).orElseThrow(null);
        taskById.setId(taskById.getId());
        taskById.setTitle(task.getTitle());
        taskById.setDescription(task.getDescription());
        taskService.saveOrUpdateTask(taskById);
        return ResponseEntity.ok(taskById);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

