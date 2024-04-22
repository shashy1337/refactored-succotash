package ru.shashy.orderrestapi.service;

import ru.shashy.orderrestapi.dto.request.AuthDto;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;

public interface AuthService {
    void register(RegistrationDto registrationDto);
    String authenticate(AuthDto authDto);
}
