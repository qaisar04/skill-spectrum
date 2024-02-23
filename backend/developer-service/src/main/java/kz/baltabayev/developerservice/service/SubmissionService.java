package kz.baltabayev.developerservice.service;

import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Submission;

import java.util.List;

public interface SubmissionService {

    Submission submit(SubmissionDto submission);

    Submission get(Long id);

    List<Submission> getAll();

    Submission update(Submission submission);

    void delete(Long id);
}
