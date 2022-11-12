package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.VistaAsistenciaMozos;

public class ControladorAsistenciaMozos implements ActionListener {
	private VistaAsistenciaMozos vista;
	private Empresa empresa;
	private static ControladorAsistenciaMozos instancia = null;
	private GestionDeMesas gestionMesas;

	public ControladorAsistenciaMozos() {
		this.vista = new VistaAsistenciaMozos();
		this.empresa = Empresa.getEmpresa();
		this.vista.setActionListener(this);
		this.gestionMesas = new GestionDeMesas();
	}

	public static ControladorAsistenciaMozos getControladorAsistencia(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorAsistenciaMozos();
		}
		instancia.vista.setListaMozos(
				instancia.empresa.getMozos().getMozos().stream().map(MozoDTO::of).toArray(MozoDTO[]::new));
		if (mostrar) {
			instancia.vista.mostrar();
		}

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "Volver":
			ControladorMesa.getControladorMesa(true);
			this.vista.esconder();
			break;
		case "Aceptar":

			break;

		}

	}

}
