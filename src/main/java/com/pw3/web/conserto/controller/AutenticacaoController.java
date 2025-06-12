package com.pw3.web.conserto.controller;

import com.pw3.domain.usuario.DadosAutenticacaoDto;
import com.pw3.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/login")
public class AutenticacaoController {
    private final AuthenticationManager manager;
    private final PW3TokenService tokenService;

    public AutenticacaoController(
            AuthenticationManager manager,
            PW3TokenService tokenService
    ) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados) {
        var authToken = new UsernamePasswordAuthenticationToken(
                dados.login(), dados.senha());
        var auth = manager.authenticate(authToken);
        var jwt = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(jwt));
    }
}
