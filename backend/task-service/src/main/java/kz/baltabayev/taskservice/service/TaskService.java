package kz.baltabayev.taskservice.service;

import kz.baltabayev.taskservice.model.entity.Task;
import kz.baltabayev.taskservice.model.types.Status;

import java.util.List;

public interface TaskService {

    void delete(Long id);

    List<Task> getAllByAssignedDeveloperIdAndStatus(Long assignedDeveloperId, Status status);

    Task get(Long id);

    List<Task> getByDeveloperId(Long id);

    Task save(Task task);

    Task update(Task task);

    List<Task> getAll();
}
