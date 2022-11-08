package com.grupo8.app.controladores;

import com.grupo8.app.vistas.VistaGestionComandas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGestionComanda implements ActionListener {
    private static ControladorGestionComanda instancia = null;
    private final VistaGestionComandas vista;

    public ControladorGestionComanda() {
        this.vista = new VistaGestionComandas();
        this.vista.setActionListener(this);
    }

    public static ControladorGestionComanda getControladorGestionComanda(boolean mostrar) {
        if (instancia == null) {
            instancia = new ControladorGestionComanda();
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
            case "AGREGAR":
                //TODO: ControladorNuevaComanda.getControladorNuevaComanda(true);
                this.vista.esconder();
                break;
            case "CERRAR":
                //TODO: ControladorCerrarComanda.get(true);
                this.vista.esconder();
                break;
            case "VOLVER":
                ControladorIniciarTurno.getControladorIniciarTurno(true);
                break;
        }
    }
}
