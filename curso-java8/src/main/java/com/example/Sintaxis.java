package com.example;

public class Sintaxis {

    public double probarSintaxis() {
        Operacion operacion = (n1, n2) -> (n1+n2)/2;

        return operacion.calcularPromedio(2, 3);
    }

    public static void main(String[] args) {
        Sintaxis app = new Sintaxis();
        System.out.println(app.probarSintaxis());
    }
}
