package com.grupo8.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReporteVentaDto {
  private MozoDTO mozo;
  private Float total;
  private Float promedio;
  private Integer cantVentas;
}
