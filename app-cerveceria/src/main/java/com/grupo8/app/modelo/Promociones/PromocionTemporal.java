package com.grupo8.app.modelo.Promociones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromocionTemporal extends Promocion {
	private String formaPago;
	private int porcentajeDescuento;
	private boolean acumulable;
}
