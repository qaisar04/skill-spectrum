package kz.baltabayev.taskservice.model.dto;

import kz.baltabayev.taskservice.model.types.Status;

import java.time.LocalDateTime;

public class TaskDto {
    private String title;
    private String description;
    private Long assignedDeveloperId;
    private LocalDateTime deadline;
    private Status status;
}
