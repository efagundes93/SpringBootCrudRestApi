package com.clientes.cadastrodeclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  Simples serviço de cadastro de clientes.
 * @author Fagundes, Emiliano
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CadastroDeClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeClientesApplication.class, args);
	}
}
