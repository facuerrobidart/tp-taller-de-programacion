package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PromoFijaRequest {
    private String nombre;
    private List<DayOfWeek> diasPromo;

    private String idProducto;
    private Boolean dosPorUno;
    private Boolean dtoPorCantidad;
    private Integer dtoPorCantMin;
    private Double dtoPorCantPrecioU;
    private boolean activa;
}
