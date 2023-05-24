package com.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="persona")
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Persona {

    @Id
    private Integer id;

    private String nombre;
}
