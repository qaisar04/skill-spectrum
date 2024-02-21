package kz.baltabayev.developerservice.controller;

import kz.baltabayev.developerservice.mapper.DeveloperMapper;
import kz.baltabayev.developerservice.model.dto.DeveloperRequest;
import kz.baltabayev.developerservice.model.entity.Developer;
import kz.baltabayev.developerservice.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dev")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;
    private final DeveloperMapper developerMapper;

    @GetMapping
    public ResponseEntity<List<Developer>> getAllStudents() {
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getInfoStudent(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getInfo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Developer> createStudent(@RequestBody DeveloperRequest developerRequest) {
        return ResponseEntity.ok(developerService.save(developerMapper.toEntity(developerRequest)));
    }

    @PostMapping("/update")
    public ResponseEntity<Developer> updateStudent(@RequestBody DeveloperRequest developerRequest) {
        return ResponseEntity.ok(developerService.update(developerMapper.toEntity(developerRequest)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        developerService.delete(id);
        return ResponseEntity.ok("Developer with id: " + id + " was deleted");
    }
}
