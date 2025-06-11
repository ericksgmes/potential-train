package com.pw3.web.conserto.controller;

import com.pw3.domain.usuario.Usuario;
import com.pw3.domain.usuario.authData;
import com.pw3.web.conserto.security.ConsertoDto;
import com.pw3.web.conserto.security.MecanicaTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;  // Objeto AuthenticationManager,
    // que será injetado aqui.
    // LEMBRAR COMENTÁRIOS UMA AULA PASSADA!!!

    @Autowired
    private MecanicaTokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid authData dados) {

        var token = new UsernamePasswordAuthenticationToken( dados.login(),
                dados.senha() );

        var authentication = manager.authenticate(token);

        // Criando o token JWT:
        var tokenJWT = tokenService.gerarToken( (Usuario) authentication.getPrincipal() );

        // Criando o DTO DadosTokenJWT a partir do token criado acima,
        // e devolvendo no corpo da respostas da requisição:
        return ResponseEntity.ok( new ConsertoDto(tokenJWT) );
    }
}
