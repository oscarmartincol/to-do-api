package com.oscarmartincol.to_do_list.service;

import com.oscarmartincol.to_do_list.model.Task;
import com.oscarmartincol.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findall() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
