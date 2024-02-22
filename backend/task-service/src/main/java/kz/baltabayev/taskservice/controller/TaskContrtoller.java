package kz.baltabayev.taskservice.controller;

import kz.baltabayev.taskservice.mapper.TaskMapper;
import kz.baltabayev.taskservice.model.dto.TaskDto;
import kz.baltabayev.taskservice.model.entity.Task;
import kz.baltabayev.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskContrtoller {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Task>> getTasksByDeveloperId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getByDeveloperId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.save(taskMapper.toEntity(taskDto)));
    }

    @PostMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.update(taskMapper.toEntity(taskDto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok("Developer with id: " + id + " was deleted");
    }
}
