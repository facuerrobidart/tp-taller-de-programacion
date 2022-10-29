package com.grupo8.app.modelo;


import com.grupo8.app.modelo.Promociones.Promocion;
import com.grupo8.app.tipos.EstadoComanda;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
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

  public CierreComanda(Comanda comanda) {
    super(comanda.getMesa());
    this.setCierre(Instant.now());
    this.setApertura(comanda.getApertura());
    this.setId(this.getId());
    this.setPedidos(comanda.getPedidos());
    this.setEstadoPedido(EstadoComanda.CERRADA);

    this.promociones = new ArrayList<>();
    total = comanda.getPedidos().stream().reduce(0F, (subtotal, pedido) -> subtotal + pedido.getProducto().getPrecio(), Float::sum);
  }
}
