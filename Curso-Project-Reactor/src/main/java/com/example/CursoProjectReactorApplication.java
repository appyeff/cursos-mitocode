package com.example;

import com.example.combinacion.Combinacion;
import com.example.condicional.Condicional;
import com.example.creacion.Creacion;
import com.example.error.ErrorOp;
import com.example.filtrado.Filtrado;
import com.example.matematico.Matematico;
import com.example.model.Persona;
import com.example.transformacion.Transformacion;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class CursoProjectReactorApplication implements CommandLineRunner {

	public void reactor() {
		Mono.just(new Persona(1, "Yeff", 26))
				.doOnNext(p->log.info("[Reactor] Persona: " + p))
				.subscribe();
	}

	public void rxjava2() {
		Observable.just(new Persona(1, "Yeff", 26))
				.doOnNext(null)
				.subscribe(p->log.info("[RxJava2] Persona: " + p));;
	}

	public void mono() {
		Mono.just(new Persona(1, "admin", 49));
	}

	public void flux() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "yeff", 78));
		personas.add(new Persona(2, "soporte", 79));
		personas.add(new Persona(3, "user", 77));

		Flux.fromIterable(personas).subscribe(p-> log.info(p.toString()));
	}

	public void fluxMono() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "yeff", 78));
		personas.add(new Persona(2, "soporte", 79));
		personas.add(new Persona(3, "user", 77));

		Flux<Persona> fx = Flux.fromIterable(personas);
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoProjectReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*mono();
		flux();
		fluxMono();

		Creacion app = new Creacion();
		app.range();
		app.repeat();

		Transformacion app2 = new Transformacion();
		app2.map();
		app2.flatMap();
		app2.groupBy();*/

		/*Filtrado app = new Filtrado();
		app.filter();
		app.distint();
		app.take();

		Combinacion app2 = new Combinacion();
		app2.merge();
		app2.zip();
		app2.zipWith();*/

		// ErrorOp app = new ErrorOp();
		//app.retry();
		//app.errorReturn();
		//app.errorResume();

		/*Condicional app = new Condicional();
		app.defaultIfEmpty();
		app.takeUntil();
		app.timeOut();*/

		Matematico app = new Matematico();
		app.average();
		app.count();
		app.min();
		app.sum();
		app.summarizing();
	}
}
