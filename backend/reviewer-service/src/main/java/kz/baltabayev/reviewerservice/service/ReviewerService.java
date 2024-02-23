package kz.baltabayev.reviewerservice.service;

import kz.baltabayev.reviewerservice.model.entity.Reviewer;
import kz.baltabayev.reviewerservice.model.payload.Task;

import java.util.List;

public interface ReviewerService {

    Reviewer save(Reviewer reviewer);

    Reviewer checkTask(Task task);

    Reviewer getById(Long id);

    Reviewer update(Long id, Reviewer reviewer);

    void delete(Long id);

    List<Reviewer> getAll();

}
