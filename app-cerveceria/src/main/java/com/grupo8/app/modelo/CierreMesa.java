package com.grupo8.app.modelo;


import com.grupo8.app.modelo.Promociones.Promocion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CierreMesa extends Cuenta {
  private Mesa mesa;
  private Cuenta cuenta;
  private List<Promocion> promociones;
  private Float total;


  public CierreMesa(Mesa mesa) {
    super();
    this.mesa = mesa;
    this.cuenta = mesa.getCuenta();
    this.promociones = new ArrayList<>();
    total = 0F;
  }
}
