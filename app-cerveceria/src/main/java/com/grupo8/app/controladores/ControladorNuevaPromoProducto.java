package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.vistas.VistaNuevaPromoProducto;



public class ControladorNuevaPromoProducto implements ActionListener {

	private static ControladorNuevaPromoProducto instancia = null;
	private VistaNuevaPromoProducto vista = null;

	private ControladorNuevaPromoProducto() {
		this.vista = new VistaNuevaPromoProducto();
		this.vista.setActionListener(this);
	}

	public static ControladorNuevaPromoProducto getControladorNuevaPromoProducto(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorNuevaPromoProducto();
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
				ControladorNuevaPromo.getControlador(true);
				this.vista.esconder();
				break;
			case "EditarPromo":
				//TODO: ControladorEditarPromo.getControladorEditarPromo(true);
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
