package com.pw3.web.conserto.controller;

import com.pw3.application.conserto.delete.DeleteConsertoService;
import com.pw3.application.conserto.delete.DeleteConsertoServiceImpl;
import com.pw3.application.conserto.get.FindConsertoService;
import com.pw3.application.conserto.get.FindConsertoServiceImpl;
import com.pw3.application.conserto.get.ResumoConsertoService;
import com.pw3.application.conserto.get.ResumoConsertoServiceImpl;
import com.pw3.application.conserto.patch.RegistraSaidaService;
import com.pw3.application.conserto.patch.RegistraSaidaServiceImpl;
import com.pw3.application.conserto.post.CreateConsertoService;
import com.pw3.application.conserto.post.CreateConsertoServiceImpl;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsertoControllerConfiguration {
    @Bean
    public CreateConsertoService createConsertoService(ConsertoRepository repo) {
        return new CreateConsertoServiceImpl(repo);
    }

    @Bean
    public RegistraSaidaService registraSaidaService(ConsertoRepository repo) {
        return new RegistraSaidaServiceImpl(repo);
    }

    @Bean
    public FindConsertoService findConsertoService(ConsertoRepository repo) {
        return new FindConsertoServiceImpl(repo);
    }

    @Bean
    public ResumoConsertoService resumoConsertoService(ConsertoRepository repo) {
        return new ResumoConsertoServiceImpl(repo);
    }

    @Bean
    public DeleteConsertoService deleteConsertoService(ConsertoRepository repo) {
        return new DeleteConsertoServiceImpl(repo);
    }

}
