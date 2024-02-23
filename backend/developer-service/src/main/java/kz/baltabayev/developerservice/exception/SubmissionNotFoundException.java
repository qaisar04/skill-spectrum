package kz.baltabayev.developerservice.exception;

public class SubmissionNotFoundException extends RuntimeException {
    public SubmissionNotFoundException(Long id) {
        super("Submission with id %s not found".formatted(id));
    }
}
