package com.example.java.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Archivo {

    public void leer() {
        try {
            String contenido = Files.readString(Path.of("src/main/resources/prueba.txt"));
            System.out.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribir() {
        try {
            //Path path = Files.writeString(Path.of("src/main/resources/prueba.txt"), "Desde JDK 11", StandardOpenOption.CREATE_NEW);
            Path path = Files.writeString(Path.of("src/main/resources/prueba.txt"), " Desde JDK 11 suscribe", StandardOpenOption.APPEND);
            System.out.println(path);
            String s = Files.readString(path);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
