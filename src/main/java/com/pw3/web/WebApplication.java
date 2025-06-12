package com.pw3.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.pw3.infrastructure")
@EntityScan(basePackages = "com.pw3.domain")
@SpringBootApplication(scanBasePackages = {
		"com.pw3.web.conserto",
		"com.pw3.application.usuario"
})

public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
