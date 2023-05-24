package com.example;

public @interface AnnotacionCustom {

    String nombre();
    boolean habilitado() default true;
}
