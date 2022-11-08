package com.grupo8.app.controladores;

import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.VistaAgregarComanda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgregarComanda implements ActionListener {
    private static ControladorAgregarComanda instancia = null;

    private final VistaAgregarComanda vista;
    private final GestionDeMesas gestionDeMesas;

    public ControladorAgregarComanda() {
        this.vista = new VistaAgregarComanda();
        this.vista.setActionListener(this);
        this.gestionDeMesas = new GestionDeMesas();
    }

    public static ControladorAgregarComanda getControladorAgregarComanda(boolean mostrar) {
        if (instancia == null) {
            instancia = new ControladorAgregarComanda();
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
                //gestionDeMesas.crearComanda(this.vista.());
                break;
            case "VOLVER":
                ControladorGestionComanda.getControladorGestionComanda(true);
                this.vista.esconder();
                break;
        }
    }
}
