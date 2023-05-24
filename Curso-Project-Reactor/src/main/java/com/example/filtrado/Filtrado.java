package com.example.filtrado;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Filtrado {

    public void filter() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distint() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(1, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));

    }

    public void take() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .take(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .takeLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 29));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));
    }
}
