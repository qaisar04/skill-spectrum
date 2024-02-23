package kz.baltabayev.developerservice.client;

import kz.baltabayev.developerservice.model.payload.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "grade-service", path = "/api/grade")
public interface GradeServiceClient {

    @PostMapping("/get/task-id/{taskId}")
    ResponseEntity<Grade> getByTaskId(@PathVariable Long taskId);
}
