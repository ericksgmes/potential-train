package com.pw3.application.usuario;

import com.pw3.infrastructure.usuarios.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements UserDetailsService {
    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
