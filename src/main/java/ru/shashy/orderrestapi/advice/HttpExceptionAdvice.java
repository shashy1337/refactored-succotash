package ru.shashy.orderrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.shashy.orderrestapi.dto.error.AppError;
import ru.shashy.orderrestapi.exception.httpEx.BadRequestException;
import ru.shashy.orderrestapi.exception.httpEx.ForbiddenException;
import ru.shashy.orderrestapi.exception.httpEx.NotFoundException;

@RestControllerAdvice
public class HttpExceptionAdvice {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public AppError handleForbiddenException(ForbiddenException e) {
        return new AppError(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError badRequestException(BadRequestException e) {
        return new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleNotFoundException(NotFoundException e) {
        return new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AppError handleNullPoint(NullPointerException e) {
        return new AppError(HttpStatus.NO_CONTENT.value(), e.getMessage());
    }

}
