package com.grupo8.app.negocio;

import com.grupo8.app.dto.PromoTemporalRequest;
import com.grupo8.app.modelo.Empresa;

public class GestionDePromos {
    private Empresa empresa;

    public GestionDePromos() {
        this.empresa = Empresa.getEmpresa();
    }

    public void agregarPromoTemporal(PromoTemporalRequest request) {

    }
}
