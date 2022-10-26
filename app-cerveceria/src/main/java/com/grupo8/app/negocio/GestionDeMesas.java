package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.dto.PedidoRequest;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import com.grupo8.app.tipos.EstadoMesa;

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

    public void editMesa(AddMesaRequest request) throws EntidadNoEncontradaException {
        Optional<Mesa> mesaAEditar = this.empresa.getMesas().stream()
                .filter(mesa -> Objects.equals(mesa.getNroMesa(), request.getNroMesa())).findFirst();

        if (mesaAEditar.isPresent()) {
            mesaAEditar.get().setCantSillas(request.getCantSillas());
            persistir();
        } else {
            throw new EntidadNoEncontradaException("No se encontro la mesa");
        }

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

    public void iniciarTurno() {
        for (Mesa mesa : this.empresa.getMesas()) {
            mesa.setEstadoMesa(EstadoMesa.LIBRE);
            mesa.setCuenta(null);
            mesa.setMozoAsignado(null);
        }
    }


    public void abrirMesa(Integer nroMesa, String idMozo) throws EntidadNoEncontradaException {
        Optional<Mesa> mesaAEditar = this.empresa.getMesas().stream()
                .filter(mesa -> Objects.equals(mesa.getNroMesa(), nroMesa)).findFirst();
        Optional<Mozo> mozoAEditar = this.empresa.getMozos().stream()
                .filter(mozo -> Objects.equals(mozo.getId(), idMozo)).findFirst();

        if (mesaAEditar.isPresent() && mozoAEditar.isPresent()) {
            mesaAEditar.get().setEstadoMesa(EstadoMesa.OCUPADA);
            mesaAEditar.get().setCuenta(new Cuenta());
            mesaAEditar.get().setMozoAsignado(mozoAEditar.get());
        } else if (!mesaAEditar.isPresent()) {
            throw new EntidadNoEncontradaException("No se encontro la mesa");
        } else {
            throw new EntidadNoEncontradaException("No se encontro el mozo");
        }
    }

    public void agregarPedidoAMesa(Integer nroMesa, PedidoRequest pedido) throws EntidadNoEncontradaException {
        Optional<Mesa> mesaAEditar = this.empresa.getMesas().stream()
                .filter(mesa -> Objects.equals(mesa.getNroMesa(), nroMesa)).findFirst();

        if (mesaAEditar.isPresent()) {
            Optional<Producto> productoAAgregar = this.empresa.getProductos().stream()
                    .filter(producto -> Objects.equals(producto.getId(), pedido.getIdProducto())).findFirst();
            if (productoAAgregar.isPresent()) {
                mesaAEditar.get().getCuenta().getPedidos().add(new Pedido(productoAAgregar.get(), pedido.getCantidad()));
            } else {
                throw new EntidadNoEncontradaException("No se encontro el producto");
            }
        } else {
            throw new EntidadNoEncontradaException("No se encontro la mesa");
        }
    }
}
