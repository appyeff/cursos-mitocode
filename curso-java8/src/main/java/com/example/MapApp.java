package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapApp {

    private Map<Integer, String> map;

    public void poblar() {
        map = new HashMap<>();
        map.put(1, "Mito");
        map.put(2, "Code");
        map.put(3, "Suscribete");
    }

    public void imprimir_v7() {
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
        }
    }

    public void imprimir_v8() {
        map.forEach((k, v) -> System.out.println("Llave: " + k + " Valor: " + v));

        map.entrySet().stream().forEach(System.out::println);
    }

    public void recolectar() {
        Map<Integer, String> mapaRecolectado = map.entrySet().stream()
                .filter(e->e.getValue().contains("o"))
                .collect(Collectors.toMap(p-> p.getKey(), p-> p.getValue()));

        mapaRecolectado.forEach((k,v)-> System.out.println("Llave: " + k + " Valor: " + v));
    }

    public void insertarSiAusente() {
        map.putIfAbsent(2, "Jaime");
    }

    public void operarSiPresente() {
        map.computeIfPresent(3, (k,v) -> k + v);
        System.out.println(map.get(3));
    }

    public void obtenerOrPredeterminado() {
        String valor = map.getOrDefault(5, "valor por defecto");
        System.out.println(valor);
    }

    public static void main(String[] args) {
        MapApp app = new MapApp();
        app.poblar();
        app.imprimir_v8();
        // app.operarSiPresente();
        // app.obtenerOrPredeterminado();
        app.recolectar();
    }
}
