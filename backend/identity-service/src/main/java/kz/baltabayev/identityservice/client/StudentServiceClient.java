package kz.baltabayev.identityservice.client;

import kz.baltabayev.identityservice.model.payload.StudentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "student-service", path = "/api/students")
public interface StudentServiceClient {
// не важно
    @PostMapping("/create")
    ResponseEntity<?> create(StudentRequest studentRequest);
}
