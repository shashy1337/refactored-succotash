package ru.shashy.orderrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.shashy.orderrestapi.dto.error.AppError;
import ru.shashy.orderrestapi.exception.NotFoundException;

@RestControllerAdvice
public class NotFoundControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleNotFoundException(NotFoundException e) {
        return new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
