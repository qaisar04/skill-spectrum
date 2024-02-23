package kz.baltabayev.developerservice.service.impl;

import kz.baltabayev.developerservice.client.TaskServiceClient;
import kz.baltabayev.developerservice.exception.SubmissionException;
import kz.baltabayev.developerservice.exception.SubmissionNotFoundException;
import kz.baltabayev.developerservice.exception.TaskNotFoundException;
import kz.baltabayev.developerservice.mapper.SubmissionMapper;
import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Submission;
import kz.baltabayev.developerservice.model.payload.Task;
import kz.baltabayev.developerservice.model.types.Status;
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
    private final TaskServiceClient taskServiceClient;

    @Override
    public Submission submit(SubmissionDto submission) {
        try {
            Task task = taskServiceClient.getTaskById(submission.taskId()).getBody();
            if (task == null) {
                throw new TaskNotFoundException(submission.taskId());
            }
            task.setStatus(Status.AWAITING_REVIEW);
            taskServiceClient.updateTask(task);
            return submissionRepository.save(submissionMapper.toEntity(submission));
        } catch (Exception e) {
            throw new SubmissionException("Error during submission", e);
        }
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
