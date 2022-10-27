package com.grupo8.app.modelo;

import com.grupo8.app.tipos.EstadoComanda;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//Representa una comanda de una mesa
@Getter
@Setter
public class Comanda {
  private String id;
  private List<Pedido> pedidos;
  private EstadoComanda estadoPedido;
  private Instant apertura;
  private Instant cierre;
  private Mesa mesa;


  public Comanda(Mesa mesa) {
    pedidos = new ArrayList<>();
    estadoPedido = EstadoComanda.ABIERTA;
    apertura = Instant.now();
    cierre = null;
    mesa = mesa;
    id = UUID.randomUUID().toString();
  }

  public void agregarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }
}