package com.example.condicional;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Condicional {
    public void defaultIfEmpty() {
        Flux.empty()
        //Mono.empty()
                .defaultIfEmpty(new Persona(0, "DEFAULT", 35))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil() {
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "yeff", 27));
        personas1.add(new Persona(2, "soporte", 28));
        personas1.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas1)
                .takeUntil(p -> p.getEdad() > 27)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeOut() throws InterruptedException {
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "yeff", 27));
        personas1.add(new Persona(2, "soporte", 28));
        personas1.add(new Persona(3, "user", 29));

        Flux.fromIterable(personas1)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }
}
