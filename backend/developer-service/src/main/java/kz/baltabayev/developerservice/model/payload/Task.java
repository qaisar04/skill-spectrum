package kz.baltabayev.developerservice.model.payload;

import kz.baltabayev.developerservice.model.types.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    private String title;
    private String description;
    private Long assignedDeveloperId;
    private LocalDateTime deadline;
    private Status status;
}
