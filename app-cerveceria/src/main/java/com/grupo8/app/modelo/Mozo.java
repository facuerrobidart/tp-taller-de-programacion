package com.grupo8.app.modelo;


import com.grupo8.app.tipos.EstadoMozo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Mozo {
    private String nombreCompleto;
    private Date fechaNacimiento;
    private int cantidadHijos;
    private EstadoMozo estadoMozo;
}
