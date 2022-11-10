package com.grupo8.app.controladores;


import com.grupo8.app.modelo.Operario;
import com.grupo8.app.negocio.GestionDeUsuarios;
import com.grupo8.app.vistas.VistaNuevoMozo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorNuevoMozo implements ActionListener {
	private static ControladorNuevoMozo instancia = null;
	private VistaNuevoMozo vista = null;
	private Operario logueado;

	private ControladorNuevoMozo() {
		this.vista = new VistaNuevoMozo();
		this.vista.setActionListener(this);
		this.logueado = null;
	}

	public static ControladorNuevoMozo getControlador(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorNuevoMozo();
		}

		if (mostrar) {
			instancia.vista.mostrar();
		}

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Listo":
			this.vista.getFormulario();
			GestionDeUsuarios g= new GestionDeUsuarios();
			g.addMozo(this.vista.getFormulario());
			this.vista.mostrarMensaje("La mesa se registro con exito");
			break;
		case "Atras":
			 ControladorSesionAdmin.getControladorSesionAdmin(true);
					this.vista.esconder();
				break;
		}
	}
}