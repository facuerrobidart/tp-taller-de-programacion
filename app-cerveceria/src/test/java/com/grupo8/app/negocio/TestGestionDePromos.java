package com.grupo8.app.negocio;

import com.grupo8.app.dto.PromoTemporalRequest;
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
    public void temp() throws MalaSolicitudException {
        PromoTemporalRequest req = new PromoTemporalRequest();
        req.setDiasPromo(List.of(DayOfWeek.MONDAY,DayOfWeek.FRIDAY));
        req.setPorcentajeDescuento(50);
        req.setAcumulable(true);
        req.setFormaPago("Efectivo");
        req.setNombre("Test promo");
        req.setActiva(true);
        
        Assert.assertNotNull(gestionDePromos.agregarPromoTemporal(req));
    }
}
