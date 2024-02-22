package kz.baltabayev.taskservice.client;

import kz.baltabayev.taskservice.model.payload.Developer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient
//public interface DevelopServiceClient {
//
//    @GetMapping("/{id}")
//    ResponseEntity<Developer> getDevelopById(@PathVariable Long id);
//}
