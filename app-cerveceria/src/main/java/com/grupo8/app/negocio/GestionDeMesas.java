package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.dto.PedidoRequest;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.EstadoInvalidoException;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.modelo.Promociones.Promocion;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import com.grupo8.app.tipos.EstadoMesa;
import com.grupo8.app.tipos.EstadoMozo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    private void persistirComandas() {
        Ipersistencia<Set<Comanda>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("comandas.xml");
            persistencia.escribir(this.empresa.getComandas());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public void iniciarTurno() throws EstadoInvalidoException {
        for (Mesa mesa : this.empresa.getMesas()) {
            mesa.setEstadoMesa(EstadoMesa.LIBRE);
            mesa.setMozoAsignado(null);
        }
        List<Promocion> promosActivas = this.empresa.getPromociones().stream().filter(promo -> promo.getDiasPromo().equals(LocalDate.now().getDayOfWeek()) && promo.isActivo()).collect(Collectors.toList());

        if (promosActivas.size() < 2) {
            throw new EstadoInvalidoException("Debe haber al menos 2 promociones activas para iniciar el turno");
        }
    }


    public void crearComanda(Integer nroMesa) throws EntidadNoEncontradaException, EstadoInvalidoException {
        Optional<Mesa> mesa = this.empresa.getMesas().stream()
                .filter(me -> Objects.equals(me.getNroMesa(), nroMesa)).findFirst();

        if (mesa.isPresent() && mesa.get().getEstadoMesa() == EstadoMesa.LIBRE) {
            mesa.get().setEstadoMesa(EstadoMesa.OCUPADA);
            if (mesa.get().getMozoAsignado() != null || mesa.get().getMozoAsignado().getEstadoMozo() != EstadoMozo.ACTIVO) {
                Comanda comanda = new Comanda(mesa.get());
                this.empresa.getComandas().add(comanda);
            } else if (mesa.get().getMozoAsignado() == null) {
                throw new EntidadNoEncontradaException("No se encontro mozo asignado");
            } else {
                throw new EstadoInvalidoException("El mozo asignado no esta activo");
            }
        } else if (mesa.get().getEstadoMesa() == EstadoMesa.OCUPADA) {
            throw new EstadoInvalidoException("La mesa ya esta ocupada");
        } else {
            throw new EntidadNoEncontradaException("No se encontro la mesa");
        }
    }

    public void agregarPedidoAComanda(PedidoRequest pedido) throws EntidadNoEncontradaException {
        Optional<Comanda> comanda = this.empresa.getComandas().stream()
                .filter(c -> Objects.equals(c.getId(), pedido.getIdComanda())).findFirst();

        if (comanda.isPresent()) {
            Optional<Producto> productoAAgregar = this.empresa.getProductos().stream()
                    .filter(producto -> Objects.equals(producto.getId(), pedido.getIdProducto())).findFirst();
            if (productoAAgregar.isPresent()) {
                comanda.get().getPedidos().add(new Pedido(productoAAgregar.get(), pedido.getCantidad()));
            } else {
                throw new EntidadNoEncontradaException("No se encontro el producto");
            }
        } else {
            throw new EntidadNoEncontradaException("No se encontro la comanda");
        }
    }

    public void cerrarTurno() {
        persistirComandas();
    }
}
