package com.grupo8.app.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producto {
    private Integer id;
    private String nombre;
    private float precio;
    private float costo;
    private Integer stock;
}
