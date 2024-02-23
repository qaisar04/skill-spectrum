package kz.baltabayev.taskservice.controller;

import kz.baltabayev.taskservice.mapper.TaskMapper;
import kz.baltabayev.taskservice.model.dto.TaskDto;
import kz.baltabayev.taskservice.model.entity.Task;
import kz.baltabayev.taskservice.model.types.Status;
import kz.baltabayev.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/dev-id/{id}")
    public ResponseEntity<List<Task>> getTasksByDeveloperId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getByDeveloperId(id));
    }

    @GetMapping("/dev-id/{id}/{status}")
    public ResponseEntity<List<Task>> getTasksByDeveloperIdAndStatus(@PathVariable Long id, @PathVariable String status) {
        return ResponseEntity.ok(taskService.getAllByDeveloperIdAndStatus(id, Status.valueOf(status.toUpperCase())));
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.save(taskMapper.toEntity(taskDto)));
    }

    @PostMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.update(task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok("Developer with id: " + id + " was deleted");
    }
}
