package com.example.transformacion;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Transformacion {

    public void map() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 25));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));

        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("X : " + x));
    }

    public void flatMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(2, "Code", 25));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .flatMap(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mito", 24));
        personas.add(new Persona(1, "Code", 25));
        personas.add(new Persona(3, "Yeff", 26));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
