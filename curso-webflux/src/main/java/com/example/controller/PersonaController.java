package com.example.controller;

import com.example.model.Persona;
import com.example.repository.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public Flux<Persona> listar() {
        return repo.listar();
    }

    @GetMapping("/{id}")
    public Mono<Persona> listarPorId(@PathVariable("id") Integer id) {
        return repo.listarPorId(id);
    }

    @PostMapping
    public Mono<Persona> registrar(@RequestBody Persona per) {
        return repo.registrar(per);
    }

    @PutMapping
    public Mono<Persona> modificar(@RequestBody Persona per) {
        return repo.modificar(per);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable("id") Integer id) {
        return repo.listarPorId(id)
                .flatMap(p->repo.eliminar(p.getIdPersona()));
    }
}
