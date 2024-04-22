package ru.shashy.orderrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shashy.orderrestapi.domain.usercontext.UserContext;

@RestController
public class TestController {

    @Autowired
    private UserContext userContext;

    @GetMapping("/ok")
    public String ok() {
        return "ok, " + userContext.getAuthUser();
    }
}
