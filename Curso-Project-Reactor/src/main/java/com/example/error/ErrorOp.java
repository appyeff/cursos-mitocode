package com.example.error;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ErrorOp {

    public void retry() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorReturn(new Persona(0, "XYZ", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0, "XYZ", 99)))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "yeff", 27));
        personas.add(new Persona(2, "soporte", 28));
        personas.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }
}
