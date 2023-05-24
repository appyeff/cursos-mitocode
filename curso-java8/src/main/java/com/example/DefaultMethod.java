package com.example;

public class DefaultMethod implements PersonaA, PersonaB{

    @Override
    public void caminar() {
        System.out.println("Hola coders");
    }

    @Override
    public void hablar() {
        PersonaA.super.hablar();
    }

    public static void main(String[] args) {
        DefaultMethod app = new DefaultMethod();
        app.caminar();
        app.hablar();

    }
}
