package com.oscarmartincol.to_do_list.controller;

import com.oscarmartincol.to_do_list.model.Task;
import com.oscarmartincol.to_do_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController (TaskService service) {
        this.service = service;
    }

    // Lista de tareas
    @GetMapping
    public List<Task> getAll() {
        return service.findall();
    }

    // Guardar nueva tarea a la base de datos.
    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(service.save(task));
    }

    // Actualizar datos de una tarea por el id
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @Valid @RequestBody Task task) {

        Task existing = service.findById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDueDate(task.getDueDate());
        existing.setCompleted(task.isCompleted());

        return ResponseEntity.ok(service.save(existing));
    }

    // Borrar una tarea por el id
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok().build();
    }
    }
