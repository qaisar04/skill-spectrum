package kz.baltabayev.taskservice.service.impl;

import kz.baltabayev.taskservice.exception.TaskNotFoundException;
import kz.baltabayev.taskservice.model.entity.Task;
import kz.baltabayev.taskservice.model.types.Status;
import kz.baltabayev.taskservice.repository.TaskRepository;
import kz.baltabayev.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task get(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public List<Task> getAllByDeveloperIdAndStatus(Long assignedDeveloperId, Status status) {
        return getByDeveloperId(assignedDeveloperId)
                .stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getByDeveloperId(Long id) {
        return taskRepository.findAllByAssignedDeveloperId(id)
                .stream()
                .sorted(Comparator.comparing(Task::getCreatedAt))
                .collect(Collectors.toList());
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
