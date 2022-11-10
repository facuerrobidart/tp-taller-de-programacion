package com.grupo8.app.negocio;

import com.grupo8.app.dto.*;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.MalaSolicitudException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.modelo.Producto;
import com.grupo8.app.modelo.Promociones.PromocionFija;
import com.grupo8.app.modelo.Promociones.PromocionTemporal;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GestionDePromos {
    private Empresa empresa;

    public GestionDePromos() {
        this.empresa = Empresa.getEmpresa();
    }

    public PromoTemporalDTO agregarPromoTemporal(PromoTemporalRequest request) throws MalaSolicitudException {
        if (request.getDiasPromo().size() < 1) {
            throw new MalaSolicitudException("Debe seleccionar al menos un dia");
        }
        if (request.getPorcentajeDescuento() <= 0 && request.getPorcentajeDescuento() > 100) {
            throw new MalaSolicitudException("El porcentaje de descuento debe ser mayor a 0 y menor a 100");
        }

        PromocionTemporal nuevo = new PromocionTemporal(
                request.getNombre(),
                request.getDiasPromo(),
                request.getFormaPago(),
                request.getPorcentajeDescuento(),
                request.isAcumulable()
        );
        this.empresa.getPromocionesTemporales().add(nuevo);
        persistirPromosTemporales();

        return PromoTemporalDTO.of(nuevo);
    }

    public PromoTemporalDTO editarPromoTemporal(PromoTemporalRequest request, String id) throws EntidadNoEncontradaException, MalaSolicitudException {
        Optional<PromocionTemporal> promo = this.empresa.getPromocionesTemporales().stream().filter(p -> p.getIdPromocion().equals(id)).findFirst();
        if (promo.isPresent()) {
            if (request.getDiasPromo().size() < 1) {
                throw new MalaSolicitudException("Debe seleccionar al menos un dia");
            }
            if (request.getPorcentajeDescuento() <= 0 && request.getPorcentajeDescuento() > 100) {
                throw new MalaSolicitudException("El porcentaje de descuento debe ser mayor a 0 y menor a 100");
            }

            PromocionTemporal promoTemporal = (PromocionTemporal) promo.get();
            promoTemporal.setNombre(request.getNombre());
            promoTemporal.setDiasPromo(request.getDiasPromo());
            promoTemporal.setFormaPago(request.getFormaPago());
            promoTemporal.setPorcentajeDescuento(request.getPorcentajeDescuento());
            promoTemporal.setAcumulable(request.isAcumulable());
            persistirPromosTemporales();

            return PromoTemporalDTO.of(promoTemporal);
        } else {
            throw new EntidadNoEncontradaException("No se encontro la promocion temporal");
        }
    }


    public void validarUpdatePromoFija(PromoFijaRequest request) throws MalaSolicitudException {

        if (request.getDiasPromo().size() < 1) {
            throw new MalaSolicitudException("Debe seleccionar al menos un dia");
        }
        if (request.getDosPorUno() && request.getDtoPorCantidad()) {
            throw new MalaSolicitudException("No puede seleccionar dos por uno y descuento por cantidad a la vez");
        }
        if (!request.getDosPorUno() && !request.getDtoPorCantidad()) {
            throw new MalaSolicitudException("Debe seleccionar al menos una opcion de descuento");
        }
    }

    public PromoFijaDTO agregarPromoFija(PromoFijaRequest request) throws MalaSolicitudException {
        Optional<Producto> producto = this.empresa.getProductos().stream()
                .filter(p -> p.getId().equals(request.getIdProducto()))
                .findFirst();

        if (!producto.isPresent()) {
            throw new MalaSolicitudException("El producto no existe");
        }

        validarUpdatePromoFija(request);

        PromocionFija promo = new PromocionFija(
                request.getNombre(),
                request.getDiasPromo(),
                producto.get(),
                request.getDosPorUno(),
                request.getDtoPorCantidad(),
                request.getDtoPorCantMin(),
                request.getDtoPorCantPrecioU()
        );

        this.empresa.getPromocionesFijas().add(promo);
        persistirPromosFijas();

        return PromoFijaDTO.of(promo);
    }

    public PromoFijaDTO editarPromoFija(PromoFijaRequest request, String id) throws EntidadNoEncontradaException, MalaSolicitudException {
        Optional<PromocionFija> promo = this.empresa.getPromocionesFijas().stream().filter(p -> p.getIdPromocion().equals(id)).findFirst();
        if (promo.isPresent()) {
            validarUpdatePromoFija(request);
            PromocionFija promoFija = (PromocionFija) promo.get();
            promoFija.setNombre(request.getNombre());
            promoFija.setDiasPromo(request.getDiasPromo());
            promoFija.setDosPorUno(request.getDosPorUno());
            promoFija.setDtoPorCant(request.getDtoPorCantidad());
            promoFija.setDtoPorCantMin(request.getDtoPorCantMin());
            promoFija.setDtoPorCantPrecioU(request.getDtoPorCantPrecioU());
            persistirPromosFijas();
            return PromoFijaDTO.of(promoFija);
        } else {
            throw new EntidadNoEncontradaException("No se encontro la promocion fija");
        }
    }

    public boolean eliminarPromoFija(String id) throws MalaSolicitudException {
        Optional<PromocionFija> promo = this.empresa.getPromocionesFijas().stream()
                .filter(p -> p.getIdPromocion().equals(id))
                .findFirst();
        if (promo.isPresent()) {
            this.empresa.getPromocionesFijas().remove(promo.get());
            persistirPromosFijas();
            return true;
        } else {
            throw new MalaSolicitudException("La promocion no existe");
        }
    }

    public void eliminarPromoTemporal(String id) throws MalaSolicitudException {
        Optional<PromocionTemporal> promo = this.empresa.getPromocionesTemporales().stream()
                .filter(p -> p.getIdPromocion().equals(id))
                .findFirst();
        if (promo.isPresent()) {
            this.empresa.getPromocionesTemporales().remove(promo.get());
            persistirPromosTemporales();
        } else {
            throw new MalaSolicitudException("La promocion no existe");
        }
    }

    private void persistirPromosFijas() {
        Ipersistencia<Set<PromocionFija>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("promocionesFijas.xml");
            persistencia.escribir(this.empresa.getPromocionesFijas());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    private void persistirPromosTemporales() {
        Ipersistencia<Set<PromocionTemporal>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("promocionesTemporales.xml");
            persistencia.escribir(this.empresa.getPromocionesTemporales());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public List<PromoFijaDTO> obtenerPromosFijas() {
        return this.empresa.getPromocionesFijas().stream()
                .map(PromoFijaDTO::of)
                .collect(Collectors.toList());
    }

    public List<PromoTemporalDTO> obtenerPromosTemporales() {
        return this.empresa.getPromocionesTemporales().stream()
                .map(PromoTemporalDTO::of)
                .collect(Collectors.toList());
    }

    public List<PromocionDTO> obtenerPromos() {
        List<PromocionDTO> promos = new ArrayList<>();
        promos.addAll(obtenerPromosFijas());
        promos.addAll(obtenerPromosTemporales());
        return promos;
    }
    public void eliminarPromo(String id) throws MalaSolicitudException {
        try {
            eliminarPromoFija(id);
        } catch (MalaSolicitudException e) {
            eliminarPromoTemporal(id);
        }
    }
}
