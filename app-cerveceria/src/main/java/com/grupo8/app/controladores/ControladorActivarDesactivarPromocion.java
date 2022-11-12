package com.grupo8.app.controladores;

import com.grupo8.app.negocio.GestionDePromos;
import com.grupo8.app.vistas.VistaActivarDesactivarPromo;

public class ControladorActivarDesactivarPromocion {
  private GestionDePromos gestionDePromos;
  private VistaActivarDesactivarPromo vista;
  private static ControladorActivarDesactivarPromocion instancia = null;

  private ControladorActivarDesactivarPromocion() {
    this.gestionDePromos = new GestionDePromos();
    this.vista = new VistaActivarDesactivarPromo();
  }

  public static ControladorActivarDesactivarPromocion get(boolean mostrar) {
    if (instancia == null) {
      instancia = new ControladorActivarDesactivarPromocion();
    }

    if (mostrar) {
      instancia.vista.mostrar();
    }

    return instancia;
  }
}
