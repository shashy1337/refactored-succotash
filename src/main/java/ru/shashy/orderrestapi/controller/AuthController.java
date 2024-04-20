package ru.shashy.orderrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shashy.orderrestapi.dto.request.AuthDto;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;
import ru.shashy.orderrestapi.dto.response.AppResponse;
import ru.shashy.orderrestapi.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AppResponse register(
            @RequestBody RegistrationDto registrationDto
    ){
        return authService.register(registrationDto);
    }

    @PostMapping("/auth")
    public AppResponse auth(
            @RequestBody AuthDto authDto
    ){
        return authService.authenticate(authDto);
    }
}
