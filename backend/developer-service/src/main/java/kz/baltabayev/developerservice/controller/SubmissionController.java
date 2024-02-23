package kz.baltabayev.developerservice.controller;

import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Submission;
import kz.baltabayev.developerservice.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/submission")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/submit")
    public Submission sumbit(@RequestBody SubmissionDto submissionDto) {
        return submissionService.submit(submissionDto);
    }
}
