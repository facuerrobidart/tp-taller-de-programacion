package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.excepciones.EstadoInvalidoException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.VistaIniciarTurno;

public class ControladorMesa  implements ActionListener {

	private VistaIniciarTurno vista;
	private Empresa empresa;
	private static  ControladorMesa instancia = null;
	private GestionDeMesas gestionMesas;
	
	
	public ControladorMesa() {
        this.vista = new VistaIniciarTurno();
        this.empresa = Empresa.getEmpresa();
        this.vista.setActionListener(this);
        this.gestionMesas= new GestionDeMesas();
	}

    public static ControladorMesa getControladorMesa(boolean mostrar) {
    	if(instancia == null) {
            instancia = new ControladorMesa();
        }
        if (mostrar) {
            instancia.vista.mostrar();
        }
    	return instancia;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		switch(comando) {
		case "NuevaMesa":
			this.vista.esconder();
			ControladorNuevaMesa.getControladorNuevaMesa(true);
			break;
		case "EditarMesa":
			this.vista.esconder();
			ControladorNuevaMesa.getControladorNuevaMesa(true);
			break;
		case "EliminarMesa":
			this.vista.esconder();
			ControladorEliminarMesa.getControladorEliminarMesa(true);
			
			break;
		case "Volver":
			this.vista.esconder();
			ControladorIniciarTurno.getControladorIniciarTurno(true);
			
			break;
			
		}
		
	}
}
