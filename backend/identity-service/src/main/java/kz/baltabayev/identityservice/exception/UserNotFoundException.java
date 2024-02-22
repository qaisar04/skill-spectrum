package kz.baltabayev.identityservice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with login %s not found".formatted(username));
    }
}
