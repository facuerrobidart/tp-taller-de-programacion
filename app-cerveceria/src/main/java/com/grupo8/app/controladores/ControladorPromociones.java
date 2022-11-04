package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.vistas.VistaPromoProducto;

public class ControladorPromociones implements ActionListener {

	private static ControladorPromociones instancia = null;
	private VistaPromoProducto vista = null;

	private ControladorPromociones() {
		this.vista = new VistaPromoProducto();
		this.vista.setActionListener(this);
	}

	public static ControladorPromociones getControladorPromociones(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorPromociones();
		}

		if (mostrar) {
			instancia.vista.mostrar();
		}

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "NuevaPromo":
			ControladorNuevaPromoProducto.getControladorControladorNuevaPromoProducto(true);
			this.vista.esconder();
			break;
		case "EditarPromo":
			ControladorNuevaPromoProducto.getControladorNuevaPromoProducto(true);
			this.vista.esconder();
			break;
		case "EliminarPromo":
			ControladorEliminarPromo.getControlador(true);
			this.vista.esconder();
			break;
		case "Volver":
			ControladorSesionOperario.getControladorSesionOperario(true);
			this.vista.esconder();
			break;

		}
	}
}