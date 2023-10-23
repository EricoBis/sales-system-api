package com.fds.sistemavendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.fds"})
public class SistemaVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
	}

}
