package ru.shashy.orderrestapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.base.TimestampCreatedUpdated;
import ru.shashy.orderrestapi.domain.entity.User;
import ru.shashy.orderrestapi.domain.enums.Role;
import ru.shashy.orderrestapi.dto.request.AuthDto;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;
import ru.shashy.orderrestapi.dto.response.AppResponse;
import ru.shashy.orderrestapi.exception.BadRequestException;
import ru.shashy.orderrestapi.service.AuthService;
import ru.shashy.orderrestapi.service.UserService;
import ru.shashy.orderrestapi.util.JwtUtil;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AppResponse register(RegistrationDto registrationDto) {
        var timeStamp = new TimestampCreatedUpdated(LocalDateTime.now(), LocalDateTime.now());
        var user = User.builder()
                .username(registrationDto.getUsername())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .email(registrationDto.getEmail())
                .role(Role.ROLE_USER)
                .timestampCreatedUpdated(timeStamp)
                .build();
        existsUserInDatabase(registrationDto.getUsername());
        userService.save(user);
        return new AppResponse("User registered successfully");
    }

    @Override
    public AppResponse authenticate(AuthDto authDto) {
        var token = new UsernamePasswordAuthenticationToken(authDto.getLogin(), authDto.getPassword());
        var auth = authenticationManager.authenticate(token);
        var user = (UserDetails) auth.getPrincipal();
        String jwt = jwtUtil.generateJwtToken(user);
        return new AppResponse(jwt);
    }

    private void existsUserInDatabase(String username) {
        if (userService.existsByUsername(username)) {
            throw new BadRequestException("Username already exists");
        }
    }
}
