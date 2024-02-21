package kz.baltabayev.taskservice.model.types;

import lombok.Getter;

@Getter
public enum Status {
    NEW("Новая"),
    IN_PROGRESS("В работе"),
    DONE("Завершена"),
    ON_HOLD("На паузе"),
    CANCELLED("Отменена");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}