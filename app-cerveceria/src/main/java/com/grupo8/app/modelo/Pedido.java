package com.grupo8.app.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class Pedido {
  private Producto producto;
  private int cantidad;
  private Instant timestamp;
}
