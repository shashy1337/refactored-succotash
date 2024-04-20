package ru.shashy.orderrestapi.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.shashy.orderrestapi.util.JwtUtil;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {


        String authHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String login = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.replace("Bearer ", "");
            login = jwtUtil.getSubject(jwtToken);
        }
        setSecurityToken(request, login, jwtToken);
        filterChain.doFilter(request, response);
    }

    private void setSecurityToken(HttpServletRequest request, String login, String jwtToken){
        if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var roles = jwtUtil.getAuthoritiesFromToken(jwtToken);
            var token = new UsernamePasswordAuthenticationToken(login, null, roles);
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }
}
