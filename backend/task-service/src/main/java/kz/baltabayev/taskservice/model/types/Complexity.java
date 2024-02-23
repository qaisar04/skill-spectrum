package kz.baltabayev.taskservice.model.types;

import lombok.Getter;

@Getter
public enum Complexity {
    EAZY(1),
    MEDIUM(2),
    HIGH(3);

    private final int value;

    Complexity(int value) {
        this.value = value;
    }
}
