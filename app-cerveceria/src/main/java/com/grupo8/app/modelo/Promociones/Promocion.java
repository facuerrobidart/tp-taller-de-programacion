package com.grupo8.app.modelo.Promociones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Promocion {
	String nombre;
	String idPromocion;
	boolean activo;
	List<DayOfWeek> diasPromo;


	public Promocion(String nombre, List<DayOfWeek> diasPromo) {
		this.nombre = nombre;
		this.idPromocion = UUID.randomUUID().toString();
		this.activo = true;
		this.diasPromo = diasPromo;
	}
}
