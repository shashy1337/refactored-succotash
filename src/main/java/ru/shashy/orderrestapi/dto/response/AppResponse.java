package ru.shashy.orderrestapi.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.shashy.orderrestapi.dto.BaseAppTemplate;

@ResponseStatus(HttpStatus.ACCEPTED)
public class AppResponse extends BaseAppTemplate {
    public AppResponse(String message) {
        super(HttpStatus.OK.value(), message);
    }
}
