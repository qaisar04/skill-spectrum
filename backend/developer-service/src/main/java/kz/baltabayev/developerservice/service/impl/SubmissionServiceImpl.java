package kz.baltabayev.developerservice.service.impl;

import kz.baltabayev.developerservice.exception.SubmissionNotFoundException;
import kz.baltabayev.developerservice.mapper.SubmissionMapper;
import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Submission;
import kz.baltabayev.developerservice.repository.SubmissionRepository;
import kz.baltabayev.developerservice.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;

    @Override
    public Submission submit(SubmissionDto submission) {
        return submissionRepository.save(submissionMapper.toEntity(submission));
    }

    @Override
    public Submission get(Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(() -> new SubmissionNotFoundException(id));
    }

    @Override
    public List<Submission> getAll() {
        return submissionRepository.findAll();
    }

    @Override
    public Submission update(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public void delete(Long id) {
        submissionRepository.deleteById(id);
    }
}
