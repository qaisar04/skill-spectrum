package kz.baltabayev.reviewerservice.service.impl;

import kz.baltabayev.reviewerservice.client.TaskServiceClient;
import kz.baltabayev.reviewerservice.exception.ReviewerNotFoundException;
import kz.baltabayev.reviewerservice.model.entity.Reviewer;
import kz.baltabayev.reviewerservice.model.payload.Task;
import kz.baltabayev.reviewerservice.model.types.Status;
import kz.baltabayev.reviewerservice.repository.ReviewerRepository;
import kz.baltabayev.reviewerservice.service.ReviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReviewerServiceImpl implements ReviewerService {

    private final ReviewerRepository reviewerRepository;
    private final TaskServiceClient taskServiceClient;

    @Override
    public Reviewer save(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    @Override
    public Reviewer checkTask(Task task) {
        List<Task> awaitingReviewTasks = Objects.requireNonNull(taskServiceClient.getAllTasks().getBody()).stream()
                .filter(t -> t.getStatus().equals(Status.AWAITING_REVIEW))
                .sorted(Comparator.comparing(Task::getCreatedAt))
                .toList();
        return null;
    }

    @Override
    public Reviewer getById(Long id) {
        return reviewerRepository.findById(id)
                .orElseThrow(() -> new ReviewerNotFoundException(id));
    }

    @Override
    public Reviewer update(Long id, Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    @Override
    public void delete(Long id) {
        reviewerRepository.deleteById(id);
    }

    @Override
    public List<Reviewer> getAll() {
        return reviewerRepository.findAll();
    }
}
