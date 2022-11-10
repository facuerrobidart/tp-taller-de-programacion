package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import org.junit.Assert;
import org.junit.Test;

public class TestGestionDeMesas {
    private GestionDeMesas gestionDeMesas;

    public TestGestionDeMesas() {
        gestionDeMesas = new GestionDeMesas();
    }

    @Test
    public void testAddMesa() throws NumeroMesaInvalidoException {
        AddMesaRequest addMesaRequest = new AddMesaRequest();
        addMesaRequest.setNroMesa(1);
        addMesaRequest.setCantSillas(4);

        Assert.assertNotNull(gestionDeMesas.addMesa(addMesaRequest));
    }

    @Test(expected = NumeroMesaInvalidoException.class)
    public void testAddMesaNumeroInvalido() throws NumeroMesaInvalidoException {
        AddMesaRequest addMesaRequest = new AddMesaRequest();
        addMesaRequest.setNroMesa(1);
        addMesaRequest.setCantSillas(4);

        gestionDeMesas.addMesa(addMesaRequest);

        gestionDeMesas.addMesa(addMesaRequest); //deberia fallar porque ya existe una mesa con ese numero
    }
}
