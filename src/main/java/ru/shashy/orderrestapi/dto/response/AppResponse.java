package ru.shashy.orderrestapi.dto.response;

import org.springframework.http.HttpStatus;
import ru.shashy.orderrestapi.dto.BaseAppTemplate;

public class AppResponse extends BaseAppTemplate {
    public AppResponse(String message) {
        super(HttpStatus.OK.value(), message);
    }
}
