package com.grupo8.app.modelo.Promociones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
@NoArgsConstructor
public class Promocion {
	String nombre;
	int idPromocion;
	boolean activo;
	DayOfWeek diasPromo;

}
