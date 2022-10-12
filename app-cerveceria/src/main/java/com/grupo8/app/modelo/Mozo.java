package com.grupo8.app.modelo;


import com.grupo8.app.tipos.EstadoMozo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Mozo {
    private String nombreCompleto;
    private Date fechaNacimiento;
    private int cantidadHijos;
    private EstadoMozo estadoMozo;
    private String id;

    public Mozo(String nombreCompleto, Date fechaNacimiento, int cantidadHijos) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.cantidadHijos = cantidadHijos;
        this.estadoMozo = EstadoMozo.ACTIVO;
        this.id = UUID.randomUUID().toString();
    }
}
