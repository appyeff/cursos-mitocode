package com.example;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

@SpringBootTest
class CursoSpringBootApplicationTests {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(1);
		us.setNombre("yeff");
		us.setClave(encoder.encode("321"));
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
