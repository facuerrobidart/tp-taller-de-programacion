package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.vistas.VistaProductos;

public class ControladorProductos implements ActionListener {
	private static ControladorProductos instancia = null;
	private VistaProductos vista = null;

	private ControladorProductos() {
		this.vista = new VistaProductos();
		this.vista.setActionListener(this);
	}

	public static ControladorProductos getControladorProductos(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorProductos();
		}

		if (mostrar) {
			instancia.vista.mostrar();
		}

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "NuevoProducto":
			ControladorNuevoProducto.getControladorNuevoProducto(true);
			vista.esconder();
			break;
		case "EditarProducto":
			ControladorNuevoProducto.getControladorNuevoProducto(true);
			vista.esconder();
			break;
		case "EliminarProducto":
			ControladorEliminarProducto.getControladorEliminarProducto(true);
			vista.esconder();
			break;
		case "Volver":
			ControladorLogin.getControladorLogin(true);
			vista.esconder();
			break;
		}
	}
}
