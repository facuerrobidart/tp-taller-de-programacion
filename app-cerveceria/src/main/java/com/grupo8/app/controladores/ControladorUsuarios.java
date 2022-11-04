package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.vistas.VistaSesionAdmin;

public class ControladorUsuarios implements ActionListener {
    private static ControladorUsuarios instancia = null;
    private VistaSesionAdmin vista = null;
    private ControladorUsuarios() {
        this.vista = new VistaSesionAdmin();
        this.vista.setActionListener(this);
    }
    public static ControladorUsuarios getControladorUsuarios(boolean mostrar) {
    	if(instancia == null) {
    		instancia = new ControladorUsuarios();
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
                break;
           
        }
    }
}