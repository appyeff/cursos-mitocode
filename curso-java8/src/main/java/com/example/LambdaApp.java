package com.example;

import java.util.*;

public class LambdaApp {

    public void ordenar() {
        List<String> lista = new ArrayList<>();
        lista.add("Mito");
        lista.add("Code");
        lista.add("MitoCode");

        lista.sort(Comparator.naturalOrder());

        for(String elemento : lista){
            System.out.println(elemento);
        }
    }

    public void calcular() {
        Operacion operacion = (n1, n2) -> (n1+n2)/2;

        System.out.println(operacion.calcularPromedio(2, 3));
    }

    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.ordenar();

        app.calcular();
    }
}
