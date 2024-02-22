package kz.baltabayev.taskservice.model.dto;

import kz.baltabayev.taskservice.model.types.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDto {
    private String title;
    private String description;
    private Long assignedDeveloperId;
    private LocalDateTime deadline;
    private Status status;
}
