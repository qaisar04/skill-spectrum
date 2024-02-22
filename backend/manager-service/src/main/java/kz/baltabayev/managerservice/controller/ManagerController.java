package kz.baltabayev.managerservice.controller;

import kz.baltabayev.managerservice.mapper.ManagerMapper;
import kz.baltabayev.managerservice.model.dto.ManagerRequest;
import kz.baltabayev.managerservice.model.entity.Manager;
import kz.baltabayev.managerservice.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerMapper managerMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Manager>> getAllManagers() {
        return ResponseEntity.ok(managerService.getAll());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getManagerInfo(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getInfo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Manager> createManager(@RequestBody ManagerRequest request) {
        return ResponseEntity.ok(managerService.save(managerMapper.toEntity(request)));
    }

    @PostMapping("/update")
    public ResponseEntity<Manager> updateManager(@RequestBody ManagerRequest request) {
        return ResponseEntity.ok(managerService.update(managerMapper.toEntity(request)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable Long id) {
        managerService.delete(id);
        return ResponseEntity.ok("Manager with id: " + id + " was deleted");
    }
}
