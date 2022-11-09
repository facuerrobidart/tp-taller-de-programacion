package com.grupo8.app.controladores;

import com.grupo8.app.dto.MesaDTO;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.EstadoInvalidoException;
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
        instancia.actualizarMesas();
        return instancia;
    }

    public void actualizarMesas() {
        this.vista.setListaMesas(gestionDeMesas.obtenerMesasLibres().toArray(new MesaDTO[0]));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "AGREGAR":
                try {
                    gestionDeMesas.crearComanda(this.vista.getMesa().getNroMesa());
                    this.vista.mostrarMensaje("Comanda agregada correctamente para la mesa " + this.vista.getMesa().getNroMesa());
                    this.vista.esconder();
                    ControladorGestionComanda.getControladorGestionComanda(true);
                } catch (EstadoInvalidoException | EntidadNoEncontradaException ex) {
                    this.vista.mostrarMensaje(ex.getMessage());
                }
                actualizarMesas();
                break;
            case "VOLVER":
                ControladorGestionComanda.getControladorGestionComanda(true);
                this.vista.esconder();
                break;
        }
    }
}
