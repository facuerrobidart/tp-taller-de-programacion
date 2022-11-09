package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.excepciones.PermisoDenegadoException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.negocio.GestionDeUsuarios;
import com.grupo8.app.vistas.VistaNuevaMesa;

public class ControladorNuevaMesa implements ActionListener {

	private VistaNuevaMesa vista;
	private Empresa empresa;
	private static ControladorNuevaMesa instancia = null;
	private GestionDeMesas gestionMesas;

	public ControladorNuevaMesa() {
		this.vista = new VistaNuevaMesa();
		this.empresa = Empresa.getEmpresa();
		this.vista.setActionListener(this);
		this.gestionMesas = new GestionDeMesas();
	}

	public static ControladorNuevaMesa getControladorNuevaMesa(boolean mostrar) {
		if (instancia == null) {
			instancia = new ControladorNuevaMesa();
		}
		if (mostrar) {
			instancia.vista.mostrar();
		}
		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
		case "Volver": 
			ControladorMesa.getControladorMesa(true);
			this.vista.esconder();
			break;
		case "Aceptar":
			GestionDeMesas g= new GestionDeMesas();
			try {
				g.addMesa(this.vista.getFormulario());
				this.vista.mensajeExito("La mesa se registro con exito");
			} catch (NumeroMesaInvalidoException e1) {
				this.vista.mensajeError("Numero de mesa invalido");
			}
				
			
			this.vista.getFormulario();
			break;
		}
	}

}
