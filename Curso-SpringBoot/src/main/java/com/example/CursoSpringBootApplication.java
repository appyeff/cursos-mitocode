package com.example;

import com.example.service.IPersonaService;
import com.example.service.PersonaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSpringBootApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(CursoSpringBootApplication.class);
	@Autowired
	private IPersonaService service;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Hola desde la consola");
		LOG.info("Curso de Spring boot");
		service.registrar("Yeferson");
	}
}
