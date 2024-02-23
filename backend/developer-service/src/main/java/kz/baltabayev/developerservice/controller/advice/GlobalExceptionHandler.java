package kz.baltabayev.developerservice.controller.advice;

import kz.baltabayev.developerservice.exception.DeveloperNotFoundException;
import kz.baltabayev.developerservice.exception.SubmissionNotFoundException;
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
}
