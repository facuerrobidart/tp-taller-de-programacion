package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AddMozoRequest {
    private String nombreCompleto;
    private Date fechaNacimiento;
    private int cantidadHijos;
}
