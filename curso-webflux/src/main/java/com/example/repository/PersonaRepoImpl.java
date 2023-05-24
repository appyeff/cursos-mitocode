package com.example.repository;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class PersonaRepoImpl implements IPersonaRepo{

    @Override
    public Mono<Persona> registrar(Persona per) {
        log.info(per.toString());
        return Mono.just(per);
    }

    @Override
    public Mono<Persona> modificar(Persona per) {
        log.info(per.toString());
        return Mono.just(per);
    }

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Yeff"));
        personas.add(new Persona(2, "Luis"));
        personas.add(new Persona(3, "Pepe"));

        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPorId(Integer id) {
        return Mono.just(new Persona(id, "pedri"));
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }
}
