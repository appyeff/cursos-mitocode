package com.example.java.optional;

import java.util.Optional;
public class Demo {

    // JDK 11
    public void estaVacio(Persona per) {
        Optional<Persona> op = Optional.ofNullable(per);
        if (op.isEmpty()) {
            System.out.println("[11] Esta vacio");
        } else {
            System.out.println("[11] Esta lleno " + op.get());
        }
    }

    // JDK 8
    public void estaPresente(Persona per) {
        Optional<Persona> op = Optional.ofNullable(per);
        if (!op.isPresent()) {
            System.out.println("[8] Esta vacio");
        } else {
            System.out.println("[8] Esta lleno " + op.get());
        }
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        //Persona per = new Persona(1, "Yeff");
        Persona per = null;

        demo.estaVacio(per);
        demo.estaPresente(per);
    }
}
