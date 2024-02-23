package kz.balatabayev.gradingservice.controller;

import kz.balatabayev.gradingservice.model.Grade;
import kz.balatabayev.gradingservice.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> save(Grade grade) {
        return ResponseEntity.ok(gradeService.save(grade));
    }

    @PostMapping("/get/task-id/{taskId}")
    public ResponseEntity<Grade> getByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(gradeService.getByTaskId(taskId));
    }
}
