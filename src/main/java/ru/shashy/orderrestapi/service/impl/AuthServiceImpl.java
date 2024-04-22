package ru.shashy.orderrestapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.dto.request.AuthDto;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;
import ru.shashy.orderrestapi.exception.httpEx.BadRequestException;
import ru.shashy.orderrestapi.service.AuthService;
import ru.shashy.orderrestapi.service.UserService;
import ru.shashy.orderrestapi.util.JwtUtil;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public void register(RegistrationDto registrationDto) {
        var user = userService.create(registrationDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userService.existsByUsername(user.getUsername())) {
            throw new BadRequestException("Username already exists");
        }
        userService.save(user);
    }

    @Override
    public String authenticate(AuthDto authDto) {
        var token = new UsernamePasswordAuthenticationToken(authDto.getLogin(), authDto.getPassword());
        var auth = authenticationManager.authenticate(token);
        var user = (UserDetails) auth.getPrincipal();
        return jwtUtil.generateJwtToken(user);
    }

}
