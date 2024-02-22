package kz.baltabayev.taskservice.model.types;

import lombok.Getter;

@Getter
public enum Status {
    IN_PROGRESS("В работе"),
    DONE("Завершена");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}