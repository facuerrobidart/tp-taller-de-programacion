package com.grupo8.app.modelo;


import com.grupo8.app.modelo.Promociones.Promocion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CierreComanda extends Comanda {
  private List<Promocion> promociones;
  private Float total;


  public CierreComanda(Mesa mesa) {
    super(mesa);
    this.promociones = new ArrayList<>();
    total = 0F;
  }
}
