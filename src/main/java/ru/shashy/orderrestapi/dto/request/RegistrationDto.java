package ru.shashy.orderrestapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class RegistrationDto {
    private String username;
    private String password;
    private String email;
}
