package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.dto.request.AuthDto;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;
import ru.shashy.orderrestapi.dto.response.AppResponse;

public interface AuthService {
    AppResponse register(RegistrationDto registrationDto);
    AppResponse authenticate(AuthDto authDto);
}
