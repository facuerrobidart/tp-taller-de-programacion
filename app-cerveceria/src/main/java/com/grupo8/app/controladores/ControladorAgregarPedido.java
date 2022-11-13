package com.grupo8.app.controladores;

import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.VistaAgregarPedidoComanda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgregarPedido implements ActionListener {
  private static ControladorAgregarPedido instancia = null;
  private final GestionDeMesas gestionDeMesas;
  private final VistaAgregarPedidoComanda vista;

  private ControladorAgregarPedido() {
    this.gestionDeMesas = new GestionDeMesas();
    this.vista = new VistaAgregarPedidoComanda();
    vista.setActionListener(this);
  }

  public static ControladorAgregarPedido get(boolean mostrar) {
    if (instancia == null) {
      instancia = new ControladorAgregarPedido();
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
      case "CONFIRMAR":
        try {
          gestionDeMesas.agregarPedidoAComanda(vista.getPedido());
          vista.mostrarMensaje("Pedido agregado");
        } catch (Exception ex) {
          vista.mostrarMensaje(ex.getMessage());
        }
        break;
      case "ATRAS":
        ControladorIniciarTurno.getControladorIniciarTurno(true);
        this.vista.esconder();
        break;
    }

  }
}
