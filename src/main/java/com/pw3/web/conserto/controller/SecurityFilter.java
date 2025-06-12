package com.pw3.web.conserto.controller;

import com.pw3.infrastructure.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final PW3TokenService tokenService;
    private final UsuarioRepository repository;

    public SecurityFilter(PW3TokenService tokenService,
                          UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository   = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header != null) {
            String token   = header.replace("Bearer ", "");
            String subject = tokenService.getSubject(token);
            var usuario    = repository.findByLogin(subject);
            var auth = new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    usuario.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
