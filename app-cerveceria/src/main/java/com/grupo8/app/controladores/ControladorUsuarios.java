package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.vistas.VistaNuevoUsuario;

public class ControladorUsuarios implements ActionListener {
	private static ControladorUsuarios instancia = null;
	private VistaNuevoUsuario vista = null;

	private ControladorUsuarios() {
		this.vista = new VistaNuevoUsuario();
		this.vista.setActionListener(this);
	}

	public static ControladorUsuarios getControladorUsuarios(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorUsuarios();
		}

		if (mostrar) {
			instancia.vista.mostrar();
		}

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "VOLVER":
			ControladorIniciarTurno.getControladorIniciarTurno(true);
			this.vista.esconder();
			break;
		}
	}
}