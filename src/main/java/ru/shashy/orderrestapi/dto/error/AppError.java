package ru.shashy.orderrestapi.dto.error;

import lombok.Data;
import ru.shashy.orderrestapi.dto.BaseAppTemplate;

import java.time.LocalDateTime;


public class AppError extends BaseAppTemplate {

    public AppError(int status, String message) {
        super(status, message);
    }
}

