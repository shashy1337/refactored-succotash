package ru.shashy.orderrestapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseAppTemplate {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public BaseAppTemplate(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
