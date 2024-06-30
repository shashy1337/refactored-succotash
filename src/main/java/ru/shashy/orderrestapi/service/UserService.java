package ru.shashy.orderrestapi.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shashy.orderrestapi.domain.entity.User;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    User create(RegistrationDto registrationDto);
    void save(User user);
}
