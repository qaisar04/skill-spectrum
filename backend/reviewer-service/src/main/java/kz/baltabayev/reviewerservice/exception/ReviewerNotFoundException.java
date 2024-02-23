package kz.baltabayev.reviewerservice.exception;

public class ReviewerNotFoundException extends RuntimeException {
    public ReviewerNotFoundException(Long id) {
        super("Reviewer with id %s not found");
    }
}
