package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping
    public Iterable<Task> getList(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable long id){
        return taskRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable long id, @RequestBody Task task){
        Task taskfROMdB = taskRepository.findById(id).get();
        BeanUtils.copyProperties(task, taskfROMdB, "id");
        return taskRepository.save(taskfROMdB);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id){
        taskRepository.deleteById(id);
    }

    @PatchMapping("/{id}:mark-as-done")
    public void markAsDone(@PathVariable long id){
        taskRepository.markAsDone(id);
    }


}
