package com.grupo8.app.modelo.Promociones;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class Promocion {
	String nombre;
	int idPromocion;
	boolean activo;
	DayOfWeek diasPromo;

}
