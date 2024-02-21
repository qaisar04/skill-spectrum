package kz.baltabayev.taskservice.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task with id %s not found".formatted(id));
    }
}
