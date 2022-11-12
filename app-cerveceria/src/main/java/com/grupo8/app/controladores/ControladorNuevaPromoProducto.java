package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.excepciones.MalaSolicitudException;
import com.grupo8.app.negocio.GestionDePromos;
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
			case "Aceptar":
				GestionDePromos g=new GestionDePromos();
			try {
				g.agregarPromoFija(this.vista.getFormulario());
				this.vista.mostrarMensaje("La promo se creo con exito");
			} catch (MalaSolicitudException e1) {
				this.vista.mostrarMensaje("No se pudo crear la promo");
				e1.printStackTrace();
			}
				
				this.vista.esconder();
				break;
			case "Volver":
				ControladorNuevaPromo.getControlador(true);
				this.vista.esconder();
				break;
			
		}
	}
}
