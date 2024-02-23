package kz.baltabayev.developerservice.controller.advice;

import kz.baltabayev.developerservice.exception.DeveloperNotFoundException;
import kz.baltabayev.developerservice.exception.SubmissionException;
import kz.baltabayev.developerservice.exception.SubmissionNotFoundException;
import kz.baltabayev.developerservice.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeveloperNotFoundException.class)
    ProblemDetail handlerDeveloperNotFoundException(DeveloperNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(SubmissionNotFoundException.class)
    ProblemDetail handlerSubmissionNotFoundException(SubmissionNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(SubmissionException.class)
    ProblemDetail handlerSubmissionException(SubmissionException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(TaskNotFoundException.class)
    ProblemDetail handlerTaskNotFoundException(TaskNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
