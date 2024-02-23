package kz.baltabayev.reviewerservice.model.payload;

import kz.baltabayev.reviewerservice.model.types.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private String title;
    private String description;
    private Long assignedDeveloperId;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private Status status;
}
