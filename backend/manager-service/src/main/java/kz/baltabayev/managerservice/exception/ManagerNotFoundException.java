package kz.baltabayev.managerservice.exception;

public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException(Long id) {
        super("Manager with id %s not found".formatted(id));
    }
}
