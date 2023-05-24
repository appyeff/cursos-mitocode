package com.example.java.lambdas;

public class AppLambda {

    public static void main(String[] args) {
        Lambda lam = new Lambda();
        lam.probar("IMPAR");
        System.out.println("=======");
        lam.probar("PAR");
        System.out.println("=======");
        lam.sumar();
    }
}
