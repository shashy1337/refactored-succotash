package ru.shashy.orderrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.shashy.orderrestapi.dto.error.AppError;
import ru.shashy.orderrestapi.exception.ForbiddenException;

@RestControllerAdvice
public class ForbiddenExceptionAdvice {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public AppError handleForbiddenException(ForbiddenException e) {
        return new AppError(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }
}
