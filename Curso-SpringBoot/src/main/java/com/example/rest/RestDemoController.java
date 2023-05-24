package com.example.rest;

import com.example.model.Persona;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

    @Autowired
    private PersonaRepository repo;

    @GetMapping
    public List<Persona> listar() {
        return repo.findAll();
    }

    @PostMapping
    public void insertar(@RequestBody Persona persona) {
        repo.save(persona);
    }

    @PutMapping
    public void modificar(@RequestBody Persona persona) {
        repo.save(persona);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        repo.deleteById(id);
    }
}
