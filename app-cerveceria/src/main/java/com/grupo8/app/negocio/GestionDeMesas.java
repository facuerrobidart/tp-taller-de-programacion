package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.dto.ComandaDTO;
import com.grupo8.app.dto.MesaDTO;
import com.grupo8.app.dto.PedidoRequest;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.EstadoInvalidoException;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.modelo.Promociones.Promocion;
import com.grupo8.app.modelo.Promociones.PromocionFija;
import com.grupo8.app.modelo.Promociones.PromocionTemporal;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import com.grupo8.app.tipos.EstadoComanda;
import com.grupo8.app.tipos.EstadoMesa;
import com.grupo8.app.tipos.EstadoMozo;

import java.time.LocalDate;
import java.util.*;
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

    private void persistirCierreComandas() {
        Ipersistencia<List<CierreComanda>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("cierres.xml");
            persistencia.escribir(this.empresa.getCierreComandas());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public void iniciarTurno() throws EstadoInvalidoException {
        for (Mesa mesa : this.empresa.getMesas()) {
            mesa.setEstadoMesa(EstadoMesa.LIBRE);
            mesa.setMozoAsignado(null);
        }
        List<Promocion> promos = new ArrayList<>();
        promos.addAll(this.empresa.getPromocionesFijas());
        promos.addAll(this.empresa.getPromocionesTemporales());

        List<Promocion> promosActivas = promos.stream().filter(promo -> promo.getDiasPromo().contains(LocalDate.now().getDayOfWeek()) && promo.isActivo()).collect(Collectors.toList());

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
                Optional<Pedido> pedidoExistente = comanda.get().getPedidos().stream()
                        .filter(p -> Objects.equals(p.getProducto().getId(), pedido.getIdProducto())).findFirst();
                if (pedidoExistente.isPresent()) { //los pedidos se agrupan por producto
                    Pedido pedidoAEditar = pedidoExistente.get();
                    pedidoAEditar.setCantidad(pedidoAEditar.getCantidad() + pedido.getCantidad());
                } else { //si no existe el pedido se crea
                    comanda.get().getPedidos().add(new Pedido(productoAAgregar.get(), pedido.getCantidad()));
                }
            } else {
                throw new EntidadNoEncontradaException("No se encontro el producto");
            }
        } else {
            throw new EntidadNoEncontradaException("No se encontro la comanda");
        }
    }

    private boolean aplicarPromocionesFijas(CierreComanda cierreComanda) {
        boolean aplicoPromo = false;
        List<Promocion> promos = new ArrayList<>();
        promos.addAll(this.empresa.getPromocionesFijas());
        promos.addAll(this.empresa.getPromocionesTemporales());

        List<Promocion> promosFijas =
                promos
                .stream()
                .filter(promo -> promo.getDiasPromo().contains(LocalDate.now().getDayOfWeek()) && promo.isActivo() && promo instanceof PromocionFija)
                .collect(Collectors.toList());

        for (Promocion promo : promosFijas) {
            PromocionFija promoFija = (PromocionFija) promo;
            Optional<Pedido> pedidoDePromo = cierreComanda.getPedidos().stream()
                    .filter(p -> Objects.equals(p.getProducto().getId(), promoFija.getProducto().getId())).findFirst();

            if (pedidoDePromo.isPresent()) {
                Pedido pedido = pedidoDePromo.get();
                if (promoFija.getDosPorUno()) {
                    int pares = Math.floorDiv(pedidoDePromo.get().getCantidad(), 2);
                    int resto = pedidoDePromo.get().getCantidad() % 2;
                    pedido.setSubtotal(pares * pedido.getProducto().getPrecio() + resto * pedido.getProducto().getPrecio());
                    pedido.setEsPromo(true);
                    cierreComanda.getPromociones().add(promoFija);
                    aplicoPromo = true;
                } else { //es una promo por cantidad
                    if (pedido.getCantidad() >= promoFija.getDtoPorCantMin()) {
                        pedido.setSubtotal((float) (pedido.getCantidad() * promoFija.getDtoPorCantPrecioU()));
                        pedido.setEsPromo(true);
                        cierreComanda.getPromociones().add(promoFija);
                        aplicoPromo = true;
                    }
                }
            }
        }

        return aplicoPromo; //Avisa si realmente logro aplicar alguna promo
    }

    private void sumarTotal(CierreComanda cierreComanda, String medioDePago) {
        List<PromocionTemporal> promosTemporales =
                this.empresa.getPromocionesTemporales()
                        .stream()
                        .filter(promo -> promo.getDiasPromo().contains(LocalDate.now().getDayOfWeek()) && promo.isActivo())
                        .collect(Collectors.toList());

        Optional<PromocionTemporal> promoTemporal = promosTemporales.stream()
                .filter(promo -> promo.getFormaPago().equals(medioDePago)).findFirst();


        cierreComanda.setTotal(cierreComanda.getPedidos()
                .stream()
                .reduce(0f, (subtotal, pedido) -> {
                    if (!promoTemporal.isPresent() || (pedido.isEsPromo() && !promoTemporal.get().isAcumulable())) {
                        return subtotal + (pedido.getSubtotal());
                    } else {
                        return  subtotal + (pedido.getSubtotal()) - (pedido.getSubtotal() * promoTemporal.get().getPorcentajeDescuento() / 100);
                    }
                }, Float::sum));
    }

    public void cerrarComanda(String idComanda, String medioDePago) throws EntidadNoEncontradaException {
        Optional<Comanda> comanda = this.empresa.getComandas().stream()
                .filter(c -> Objects.equals(c.getId(), idComanda)).findFirst();
        if (comanda.isPresent()) {
            CierreComanda cierre = new CierreComanda(comanda.get());
            aplicarPromocionesFijas(cierre);
            sumarTotal(cierre, medioDePago);
            cierre.setEstadoPedido(EstadoComanda.CERRADA);

            this.empresa.getCierreComandas().add(cierre);
            this.empresa.getComandas().remove(comanda.get());

            persistirCierreComandas();
        } else {
            throw new EntidadNoEncontradaException("No se encontro la comanda");
        }
    }

    public List<MesaDTO> obtenerMesas() {
        return this.empresa.getMesas().stream()
                .map(MesaDTO::of)
                .collect(Collectors.toList());
    }

    public List<ComandaDTO> obtenerComandas() {
        return this.empresa.getComandas().stream()
                .map(ComandaDTO::of)
                .collect(Collectors.toList());
    }


    public void cerrarTurno() throws EstadoInvalidoException {
        if (empresa.getComandas().size() > 0) {
            throw new EstadoInvalidoException("No se puede cerrar el turno, hay comandas abiertas");
        }
        persistirCierreComandas();
    }
}
