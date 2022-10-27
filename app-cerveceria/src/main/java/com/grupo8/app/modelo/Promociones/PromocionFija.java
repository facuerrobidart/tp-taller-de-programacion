package com.grupo8.app.modelo.Promociones;

import com.grupo8.app.modelo.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromocionFija extends Promocion {
	Producto producto;
	boolean dosPorUno;
	boolean dtoPorCant;
	int dtoPorCantMin;
	double dtoPorCantPrecioU;
}
