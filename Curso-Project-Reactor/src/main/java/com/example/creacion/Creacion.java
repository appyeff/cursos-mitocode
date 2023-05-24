package com.example.creacion;

import com.example.model.Persona;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Creacion {

    public void justFrom() {

        Mono.just(new Persona(1, "yeff", 36));
        //Flux.fromIterable(coleccion);
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    public void repeat() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 78));
        personas.add(new Persona(2, "soporte", 79));
        personas.add(new Persona(3, "user", 77));

        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
    }
}
