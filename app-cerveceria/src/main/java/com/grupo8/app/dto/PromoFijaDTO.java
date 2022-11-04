package com.grupo8.app.dto;

import com.grupo8.app.modelo.Promociones.PromocionFija;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PromoFijaDTO {
    private ProductoDTO producto;
    private Boolean dosPorUno;
    private Boolean dtoPorCant;
    private Integer dtoPorCantMin;
    private Double dtoPorCantPrecioU;

    private String nombre;
    private String idPromocion;
    private boolean activo;
    private List<DayOfWeek> diasPromo;

    public static PromoFijaDTO of(PromocionFija promo) {
        PromoFijaDTO promoDTO = new PromoFijaDTO();
        promoDTO.setProducto(ProductoDTO.of(promo.getProducto()));
        promoDTO.setDosPorUno(promo.getDosPorUno());
        promoDTO.setDtoPorCant(promo.getDtoPorCant());
        promoDTO.setDtoPorCantMin(promo.getDtoPorCantMin());
        promoDTO.setDtoPorCantPrecioU(promo.getDtoPorCantPrecioU());

        promoDTO.setNombre(promo.getNombre());
        promoDTO.setIdPromocion(promo.getIdPromocion());
        promoDTO.setActivo(promo.isActivo());
        promoDTO.setDiasPromo(promo.getDiasPromo());
        return promoDTO;
    }
}
