package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.entity.User;
import ru.shashy.orderrestapi.exception.ForbiddenException;
import ru.shashy.orderrestapi.exception.NotFoundException;
import ru.shashy.orderrestapi.repository.UserRepository;
import ru.shashy.orderrestapi.service.UserService;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        return user.stream()
                .findAny()
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}
