package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.dto.MesaDTO;
import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeUsuarios;
import com.grupo8.app.vistas.VistaEliminarMozo;

public class ControladorEliminarMozo implements ActionListener {

	private VistaEliminarMozo vista;
	private Empresa empresa;
	private static ControladorEliminarMozo instancia = null;
	private GestionDeUsuarios gestionUsuarios;

	public ControladorEliminarMozo() {
		this.vista = new VistaEliminarMozo();
		this.empresa = Empresa.getEmpresa();
		this.vista.setActionListener(this);
		this.gestionUsuarios = new GestionDeUsuarios();
		this.vista.setListaMozos(gestionUsuarios.obtenerMozos().toArray(new MozoDTO[0]));
	}

	public static ControladorEliminarMozo getControladorEliminarMozo(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorEliminarMozo();
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
		case "Listo":
			this.gestionUsuarios.deleteMozo(this.vista.getMozo());
			this.vista.setListaMozos(gestionUsuarios.obtenerMozos().toArray(new MozoDTO[0]));
			this.vista.mensajeExito("mozo eliminado correctamente");
			break;
		case "Atras":
			this.vista.esconder();
			ControladorSesionAdmin.getControladorSesionAdmin(true);
			break;
		}

	}
}