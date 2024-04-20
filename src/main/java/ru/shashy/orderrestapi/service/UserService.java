package ru.shashy.orderrestapi.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shashy.orderrestapi.domain.entity.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    void save(User user);
}
