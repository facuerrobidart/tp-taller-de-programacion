package com.grupo8.app.modelo;

import com.grupo8.app.tipos.EstadoComanda;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


//Representa una comanda de una mesa
@Getter
@Setter
public class Cuenta {
  private List<Pedido> pedidos;
  private EstadoComanda estadoPedido;
  private Instant apertura;
  private Instant cierre;


  public Cuenta() {
    pedidos = new ArrayList<>();
    estadoPedido = EstadoComanda.ABIERTA;
    apertura = Instant.now();
    cierre = null;
  }
}
