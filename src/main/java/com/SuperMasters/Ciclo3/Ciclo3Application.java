package com.SuperMasters.Ciclo3;

import com.SuperMasters.Ciclo3.entities.Empleado;
import com.SuperMasters.Ciclo3.entities.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;

@EnableJpaAuditing
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {



	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}



}
