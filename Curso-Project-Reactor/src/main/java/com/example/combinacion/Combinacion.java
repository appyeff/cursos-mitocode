package com.example.combinacion;

import com.example.model.Persona;
import com.example.model.Venta;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Combinacion {

    public void merge() {
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Mito", 24));
        personas1.add(new Persona(2, "Code", 29));
        personas1.add(new Persona(3, "Yeff", 26));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Mito", 24));
        personas2.add(new Persona(2, "Code", 29));
        personas2.add(new Persona(3, "Yeff", 26));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));
    }

    public void zip() {
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Mito", 24));
        personas1.add(new Persona(2, "Code", 29));
        personas1.add(new Persona(3, "Yeff", 26));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Mito", 24));
        personas2.add(new Persona(2, "Code", 29));
        personas2.add(new Persona(3, "Yeff", 26));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> log.info(x));

        Flux.zip(fx1, fx2, fx3)
                .subscribe(x-> log.info(x.toString()));
    }

    public void zipWith() {
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Mito", 24));
        personas1.add(new Persona(2, "Code", 29));
        personas1.add(new Persona(3, "Yeff", 26));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Mito", 24));
        personas2.add(new Persona(2, "Code", 29));
        personas2.add(new Persona(3, "Yeff", 26));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx2, (p1, v1) -> String.format("Flux1: %s, Flux2: %s", p1, v1))
                .subscribe(x -> log.info(x));
    }
}
