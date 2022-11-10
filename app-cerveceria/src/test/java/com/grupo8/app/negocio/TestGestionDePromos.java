package com.grupo8.app.negocio;

import com.grupo8.app.dto.PromoTemporalDTO;
import com.grupo8.app.dto.PromoTemporalRequest;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.MalaSolicitudException;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class TestGestionDePromos {
    private GestionDePromos gestionDePromos;

    public TestGestionDePromos() {
        this.gestionDePromos = new GestionDePromos();
    }

    @Test
    public void testPromoTempExito() throws MalaSolicitudException {
        PromoTemporalRequest req = new PromoTemporalRequest();
        req.setDiasPromo(List.of(DayOfWeek.MONDAY,DayOfWeek.FRIDAY));
        req.setPorcentajeDescuento(50);
        req.setAcumulable(true);
        req.setFormaPago("Efectivo");
        req.setNombre("Test promo");
        req.setActiva(true);

        Assert.assertNotNull(gestionDePromos.agregarPromoTemporal(req));
    }

    @Test(expected = MalaSolicitudException.class)
    public void testPromoTempFalla() throws MalaSolicitudException {
        PromoTemporalRequest req = new PromoTemporalRequest();
        req.setDiasPromo(new ArrayList<>()); //Deberia fallar por no tener dias
        req.setPorcentajeDescuento(50);
        req.setAcumulable(true);
        req.setFormaPago("Efectivo");
        req.setNombre("Test promo");
        req.setActiva(true);

        gestionDePromos.agregarPromoTemporal(req);
    }

    @Test(expected = MalaSolicitudException.class)
    public void testPromoTempFalla2() throws MalaSolicitudException {
        PromoTemporalRequest req = new PromoTemporalRequest();
        req.setDiasPromo(List.of(DayOfWeek.MONDAY,DayOfWeek.FRIDAY));
        req.setPorcentajeDescuento(0); //Deberia fallar por tener porcentaje 0
        req.setAcumulable(true);
        req.setFormaPago("Efectivo");
        req.setNombre("Test promo");
        req.setActiva(true);

        gestionDePromos.agregarPromoTemporal(req);
    }

    @Test
    public void testEditarPromoTemporal() throws MalaSolicitudException, EntidadNoEncontradaException {
        PromoTemporalRequest req = new PromoTemporalRequest();
        req.setDiasPromo(List.of(DayOfWeek.MONDAY,DayOfWeek.FRIDAY));
        req.setPorcentajeDescuento(50);
        req.setAcumulable(true);
        req.setFormaPago("Efectivo");
        req.setNombre("Test promo");
        req.setActiva(true);
        PromoTemporalDTO promo = gestionDePromos.agregarPromoTemporal(req);
        Assert.assertNotNull(promo);

        promo.setPorcentajeDescuento(25);
        promo.setNombre("Test promo editada");

        req = PromoTemporalRequest.of(promo);
        Assert.assertNotNull(gestionDePromos.editarPromoTemporal(req, promo.getIdPromocion()));
    }
}
