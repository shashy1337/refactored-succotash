package ru.shashy.orderrestapi.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/ok")
    public String ok() {
        return "ok, " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
