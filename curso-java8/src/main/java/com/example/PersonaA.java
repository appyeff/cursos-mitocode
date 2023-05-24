package com.example;

public interface PersonaA {
    public void caminar();

    default public void hablar() {
        System.out.println("Saludos coders - PersonaA");
    }
}
