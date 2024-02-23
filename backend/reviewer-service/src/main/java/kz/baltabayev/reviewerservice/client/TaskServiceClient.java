package kz.baltabayev.reviewerservice.client;

import kz.baltabayev.reviewerservice.model.payload.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "task-service", path = "/api/task")
public interface TaskServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<List<Task>> getAllTasks();
}
