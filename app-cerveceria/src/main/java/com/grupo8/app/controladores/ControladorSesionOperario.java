package com.grupo8.app.controladores;

import com.grupo8.app.vistas.VistaSesionAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorSesionOperario implements ActionListener {
    private static ControladorSesionOperario instancia = null;
    private VistaSesionAdmin vista = null;
    private ControladorSesionOperario() {
        this.vista = new VistaSesionAdmin();
        this.vista.setActionListener(this);
    }
    public static ControladorSesionOperario getControladorSesionOperario(boolean mostrar) {
    	if(instancia == null) {
    		instancia = new ControladorSesionOperario();
    	}

        if (mostrar) {
            instancia.vista.mostrar();
        }

    	return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "IniciarTurno":
            	ControladorIniciarTurno.getControladorIniciarTurno(true);
            	this.vista.esconder();
            	break;
            case "ABMMesas":
            	ControladorMesa.getControladorMesa(true);
            	this.vista.esconder();
            	break;
            case "ABMProductos":
            	ControladorProductos.getControladorProductos(true);
            	this.vista.esconder();
            	break;
            case "Promociones":
            	ControladorPromociones.getControladorPromociones(true);
            	this.vista.esconder();
            	break;
            case "Estadisticas":
                ControladorLogin.getControladorLogin(true);
                vista.esconder();
                break;
            case "CERRAR":
            	ControladorLogin.getControladorLogin(true);
            	vista.esconder();
            	break;
        }
    }
}
