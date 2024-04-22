package ru.shashy.orderrestapi.exception.httpEx;

import ru.shashy.orderrestapi.exception.base.AbstractExceptionHttpHandler;

import java.io.Serial;

public class NotFoundException extends AbstractExceptionHttpHandler {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}
