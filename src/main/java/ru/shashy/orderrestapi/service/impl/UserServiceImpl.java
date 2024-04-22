package ru.shashy.orderrestapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.shashy.orderrestapi.domain.base.TimestampCreatedUpdated;
import ru.shashy.orderrestapi.domain.entity.User;
import ru.shashy.orderrestapi.domain.enums.Role;
import ru.shashy.orderrestapi.dto.request.RegistrationDto;
import ru.shashy.orderrestapi.exception.httpEx.NotFoundException;
import ru.shashy.orderrestapi.repository.UserRepository;
import ru.shashy.orderrestapi.service.UserService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
    public User create(RegistrationDto registrationDto) {
        var timeStamp = new TimestampCreatedUpdated(LocalDateTime.now(), LocalDateTime.now());
        return User.builder()
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .email(registrationDto.getEmail())
                .role(Role.ROLE_USER)
                .timestampCreatedUpdated(timeStamp)
                .build();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
