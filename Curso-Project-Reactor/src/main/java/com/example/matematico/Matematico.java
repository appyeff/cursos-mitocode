package com.example.matematico;

import com.example.combinacion.Combinacion;
import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Matematico {

    public void average() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(p -> log.info(p.toString()));
    }

    public void count() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .count()
                .subscribe(x-> log.info("Cantidad: " + x));
    }

    public void min() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(p-> log.info(p.get().toString()));
    }

    public void sum() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(x->log.info("Suma: " + x));
    }

    public void summarizing() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe(x-> log.info("Resumen: " + x));
    }
}
