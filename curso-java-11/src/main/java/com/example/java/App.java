package com.example.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public void estaVacio(String texto) {
        System.out.println(texto.isBlank());
    }

    public void repetir(String texto, int cantidad) {
        var repetido = texto.repeat(cantidad);
        System.out.println(repetido);
    }

    public void convertirLista(String texto) {
        System.out.println(texto.lines().collect(Collectors.toList()));
    }

    public void removerEspacios(String texto) {
        System.out.println(texto.strip());
        System.out.println(texto.stripLeading());
        System.out.println(texto.stripTrailing());
        System.out.println(texto.trim());
    }

    public static void main(String[] args) {

        App app = new App();
        app.estaVacio("VACIO");
        app.estaVacio("  ");
        app.repetir("MITO", 3);
        app.convertirLista("1, 2, 4, 5");
        app.removerEspacios(" M MITO CODE E ");

    }
}
