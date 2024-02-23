package kz.baltabayev.taskservice.model.entity;

import jakarta.persistence.*;
import kz.baltabayev.taskservice.model.types.Complexity;
import kz.baltabayev.taskservice.model.types.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Complexity complexity;
    private Status status;
    private Long assignedDeveloperId;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;


    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        status = Status.IN_PROGRESS;
    }
}
