package ru.shashy.orderrestapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public @Data class AuthDto {
    private String login;
    private String password;
}
