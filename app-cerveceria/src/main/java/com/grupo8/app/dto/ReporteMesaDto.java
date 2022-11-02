package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReporteMesaDto {
  private int numeroMesa;
  private float ventaPromedio;
  private float ventasTotales;
  private int cantidadVentas;

}
