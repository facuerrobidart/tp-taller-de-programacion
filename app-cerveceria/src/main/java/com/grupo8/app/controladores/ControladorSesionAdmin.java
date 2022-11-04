package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorSesionAdmin implements ActionListener {
    private static ControladorSesionAdmin instancia = null;
    private ControladorLogin controladorLogin = null;
    private ControladorSesionAdmin() {
    }
    public static ControladorSesionAdmin get() {
    	if(instancia == null) {
    		instancia = new ControladorSesionAdmin();
    	}
    	return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
