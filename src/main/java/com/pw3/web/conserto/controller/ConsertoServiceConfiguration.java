package com.pw3.web.conserto.controller;

import com.pw3.application.conserto.create.CreateConsertoService;
import com.pw3.application.conserto.create.CreateConsertoServiceImpl;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsertoServiceConfiguration {
    @Bean
    public CreateConsertoService createConsertoService(
            ConsertoRepository consertoRepository
    ) {
        return new CreateConsertoServiceImpl(consertoRepository);
    }
}
