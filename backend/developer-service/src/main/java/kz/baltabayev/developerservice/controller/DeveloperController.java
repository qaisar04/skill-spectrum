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
@RequestMapping("/api/dev")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;
    private final DeveloperMapper developerMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDevelopById(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.get(id));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getInfoDeveloper(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getInfo(id));
    }

//    public ResponseEntity<?> sendTask(@PostMapping )

    @PostMapping("/create")
    public ResponseEntity<Developer> createDeveloper(@RequestBody DeveloperRequest developerRequest) {
        return ResponseEntity.ok(developerService.save(developerMapper.toEntity(developerRequest)));
    }

    @PostMapping("/update")
    public ResponseEntity<Developer> updateDeveloper(@RequestBody DeveloperRequest developerRequest) {
        return ResponseEntity.ok(developerService.update(developerMapper.toEntity(developerRequest)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {
        developerService.delete(id);
        return ResponseEntity.ok("Developer with id: " + id + " was deleted");
    }
}
