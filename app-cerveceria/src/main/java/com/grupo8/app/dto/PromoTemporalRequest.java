package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PromoTemporalRequest {
    private String nombre;
    List<DayOfWeek> diasPromo;

    private String formaPago;
    private int porcentajeDescuento;
    private boolean acumulable;

}
