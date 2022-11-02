package com.grupo8.app.negocio;

import com.grupo8.app.dto.ReporteMesaDto;
import com.grupo8.app.modelo.CierreComanda;
import com.grupo8.app.modelo.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionDeReportes {
  private Empresa empresa;

  public GestionDeReportes() {
    this.empresa = Empresa.getEmpresa();
  }

  public List<ReporteMesaDto> generarPromedioDeVentaPorMesa() {
    List<CierreComanda> cierres = empresa.getCierreComandas();
    List<ReporteMesaDto> resultado = new ArrayList<>();

    for (CierreComanda cierre : cierres) {
      Optional<ReporteMesaDto> yaExiste = resultado.stream().filter(r -> r.getNumeroMesa() == cierre.getMesa().getNroMesa()).findFirst();

      if (yaExiste.isPresent()) {
        ReporteMesaDto reporte = yaExiste.get();
        reporte.setCantidadVentas(reporte.getCantidadVentas() + 1);
        reporte.setVentasTotales(reporte.getVentasTotales() + cierre.getTotal());
        reporte.setVentaPromedio(reporte.getVentasTotales() / reporte.getCantidadVentas());
      } else {
        ReporteMesaDto reporte = new ReporteMesaDto();
        reporte.setNumeroMesa(cierre.getMesa().getNroMesa());
        reporte.setCantidadVentas(1);
        reporte.setVentasTotales(cierre.getTotal());
        reporte.setVentaPromedio(cierre.getTotal());
        resultado.add(reporte);
      }
    }

    return resultado;
  }



}
