package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.modelo.Mesa;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class GestionDeMesas {
    public Empresa empresa;

    public GestionDeMesas(Empresa empresa) {
        this.empresa = Empresa.getEmpresa();
    }

    public void addMesa(AddMesaRequest request) throws NumeroMesaInvalidoException {

        Optional<Mesa> potencialDuplicado =
                this.empresa.getMesas().stream()
                        .filter(mesa -> Objects.equals(mesa.getNroMesa(), request.getNroMesa())).findFirst();

        if (!potencialDuplicado.isPresent()) {
            this.empresa.getMesas().add(new Mesa(request.getNroMesa(), request.getCantSillas()));
            persistir();
        } else {
            throw new NumeroMesaInvalidoException("Ya existe una mesa con ese numero");
        }
    }

    public void editMesa(AddMesaRequest request) {

    }

    public void deleteMesa(Integer nroMesa) {
        this.empresa.getMesas().removeIf(mesa -> nroMesa.equals(mesa.getNroMesa()));
        persistir();
    }

    private void persistir() {
        Ipersistencia<Set<Mesa>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mesas.xml");
            persistencia.escribir(this.empresa.getMesas());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }
}
