package com.grupo8.app.controladores;

import com.grupo8.app.vistas.VistaSesionAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorSesionAdmin implements ActionListener {
    private static ControladorSesionAdmin instancia = null;
    private VistaSesionAdmin vista = null;
    private ControladorSesionAdmin() {
        this.vista = new VistaSesionAdmin();
        this.vista.setActionListener(this);
    }
    public static ControladorSesionAdmin get(boolean mostrar) {
    	if(instancia == null) {
    		instancia = new ControladorSesionAdmin();
    	}

        if (mostrar) {
            instancia.vista.mostrar();
        }

    	return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "PRODUCTOS":
                break;
            case "PROMOCIONES":
                break;
            case "OPERARIOS":
                break;
            case "ESTADISTICAS":
                break;
            case "CERRAR":
                ControladorLogin CLogin = ControladorLogin.get(true);
                vista.esconder();
                break;
        }
    }
}
