package com.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Vendas Project",
		version = "1.0.0",
		description = "This is a project where I practice what I have been learning daily!",
		termsOfService = "IBA",
		contact = @Contact(
			name = "Iury Barbosa Alves",
			email = "iury_barbosa07@hotmail.com"
		),
		license = @License(
			name = "licence",
			url = "IBA"
		)
	)
)
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
