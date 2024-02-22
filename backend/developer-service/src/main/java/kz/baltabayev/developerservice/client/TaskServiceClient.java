package kz.baltabayev.developerservice.client;

import kz.baltabayev.developerservice.model.payload.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-service", path = "/api/task")
public interface TaskServiceClient {

    @GetMapping("/id/{id}")
    ResponseEntity<List<Task>> getTasksByDeveloperId(@PathVariable Long id);
}
