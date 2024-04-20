package ru.shashy.orderrestapi.exception.base;

import java.io.Serializable;

public abstract class AbstractExceptionHttpHandler extends RuntimeException implements Serializable {

    public AbstractExceptionHttpHandler(String message) {
        super(String.format("%s", message));
    }
}
