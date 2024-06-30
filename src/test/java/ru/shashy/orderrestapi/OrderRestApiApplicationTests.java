package ru.shashy.orderrestapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.shashy.orderrestapi.domain.entity.Products;
import ru.shashy.orderrestapi.repository.ProductsRepository;
import ru.shashy.orderrestapi.util.JwtUtil;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

@SpringBootTest
@Slf4j
class OrderRestApiApplicationTests {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    void contextLoads() {
        // Создание экземпляра SecureRandom для генерации криптографически безопасных случайных чисел
        SecureRandom random = new SecureRandom();

        // Создание байтового массива размером 32 байта (256 бит)
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);

        // Преобразование байтов в строку в шестнадцатеричном формате
        String hexString = new BigInteger(1, bytes).toString(16);

        // Вывод строки в шестнадцатеричном формате
        log.info(new String(Base64.getEncoder().encode(bytes)));
    }

    @Test
    void testJwt() {
        var s = jwtUtil.generateJwtToken(new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            }

            @Override
            public String getPassword() {
                return "23451969As";
            }

            @Override
            public String getUsername() {
                return "shashy";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        });

        log.info(s);
    }

    @Test
    void testHashcodeAndEquals() {
        Optional<Products> p1 = productsRepository.findById(1L);
        Optional<Products> p2 = productsRepository.findById(1L);
        System.out.println(p1.equals(p2));
    }


}
