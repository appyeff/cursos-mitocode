package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Venta {

    private Integer idVenta;
    private LocalDateTime fecha;


}
