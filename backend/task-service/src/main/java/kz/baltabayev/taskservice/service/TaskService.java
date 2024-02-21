package kz.baltabayev.taskservice.service;

import kz.baltabayev.taskservice.model.entity.Task;

import java.util.List;

public interface TaskService {

    void delete(Long id);

    Task get(Long id);

    Task save(Task task);

    Task update(Task task);

    List<Task> getAll();
}
