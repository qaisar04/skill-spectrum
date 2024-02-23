package kz.baltabayev.developerservice.service;

import kz.baltabayev.developerservice.model.dto.DeveloperInfoResponse;
import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Developer;
import kz.baltabayev.developerservice.model.payload.Task;

import java.util.List;

public interface DeveloperService {

    DeveloperInfoResponse getInfo(Long id);

    List<Task> getByDeveloperId(Long id);

    void delete(Long id);

    Developer get(Long id);

    Developer save(Developer dev);

    Developer update(Developer dev);

    List<Developer> getAll();
}