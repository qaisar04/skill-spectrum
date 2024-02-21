package kz.baltabayev.developerservice.exception;

public class DeveloperNotFoundException extends RuntimeException {
    public DeveloperNotFoundException(Long id) {
        super("Developer with id %s not found".formatted(id));
    }
}
