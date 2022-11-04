package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.VistaIniciarTurno;

public class ControladorNuevaMesa  implements ActionListener {

	private VistaIniciarTurno vista;
	private Empresa empresa;
	private static  ControladorNuevaMesa instancia = null;
	private GestionDeMesas gestionMesas;
	
	
	public ControladorNuevaMesa() {
        this.vista = new VistaIniciarTurno();
        this.empresa = Empresa.getEmpresa();
        this.vista.setActionListener(this);
        this.gestionMesas= new GestionDeMesas();
	}

    public static ControladorNuevaMesa getControladorNuevaMesa(boolean mostrar) {
    	if(instancia == null) {
            instancia = new ControladorNuevaMesa();
        }
        if (mostrar) {
            instancia.vista.mostrar();
        }
    	return instancia;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		}
		
}

