package com.grupo8.app.modelo.Promociones;

import com.grupo8.app.modelo.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PromocionFija extends Promocion {
	Producto producto;
	Boolean dosPorUno;
	Boolean dtoPorCant;
	Integer dtoPorCantMin;
	Double dtoPorCantPrecioU;

	public PromocionFija(String nombre, List<DayOfWeek> diasPromo, Producto producto, Boolean dosPorUno, Boolean dtoPorCant, Integer dtoPorCantMin, Double dtoPorCantPrecioU) {
		super(nombre, diasPromo);
		this.producto = producto;
		this.dosPorUno = dosPorUno;
		this.dtoPorCant = dtoPorCant;
		this.dtoPorCantMin = dtoPorCantMin;
		this.dtoPorCantPrecioU = dtoPorCantPrecioU;
	}
}
