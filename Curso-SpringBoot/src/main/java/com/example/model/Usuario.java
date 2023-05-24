package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    private int id;
    private String nombre;
    private String clave;
}
