package ru.shashy.orderrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.shashy.orderrestapi.dto.error.AppError;
import ru.shashy.orderrestapi.exception.BadRequestException;

@RestControllerAdvice
public class BadRequestControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError badRequestException(BadRequestException e) {
        return new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
