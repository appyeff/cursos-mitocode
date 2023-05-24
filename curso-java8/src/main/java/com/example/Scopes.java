package com.example;

public class Scopes {
    private static double atributo1;
    private double atributo2;
    public double probarLocalVariable() {
        final double n3 = 3;
        Operacion op = new Operacion() {
            @Override
            public double calcularPromedio(double n1, double n2) {
                return n1 + n2 + n3;
            }
        };
        return op.calcularPromedio(1, 1);
    };

    public double probarAtributosStaticVariables() {

        Operacion operacion = (x, y) -> {
            atributo1 = x + y;
            atributo2 = atributo1;
            return atributo2;
        };
        return operacion.calcularPromedio(5, 3);
    }

    public static void main(String[] args) {
        Scopes app = new Scopes();
        System.out.println(app.probarLocalVariable());
        System.out.println(app.probarAtributosStaticVariables());
    }
}
