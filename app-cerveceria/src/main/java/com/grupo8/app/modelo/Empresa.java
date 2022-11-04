package com.grupo8.app.modelo;

import com.grupo8.app.excepciones.CredencialesInvalidasException;
import com.grupo8.app.modelo.Promociones.Promocion;
import com.grupo8.app.modelo.Promociones.PromocionFija;
import com.grupo8.app.modelo.Promociones.PromocionTemporal;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.*;

@Getter
@Setter
public class Empresa {

    private static Empresa empresa;
    private String nombre;
    private Set<Mozo> mozos;
    private Set<Mesa> mesas;
    private Set<Producto> productos;
    private Set<Operario> operarios;
    private List<Comanda> comandas;
    private List<CierreComanda> cierreComandas;
    private Set<PromocionFija> promocionesFijas;
    private Set<PromocionTemporal> promocionesTemporales;
    private Operario usuarioLogueado;


    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    private Empresa() {
        comandas = new ArrayList<>();
        cargarMesas();
        cargarMozos();
        cargarProductos();
        cargarOperarios();
        cargarComandasCerradas();
        cargarPromocionesFijas();
        cargarPromocionesTemporales();
    }

    private void cargarOperarios() {
        Ipersistencia<Set<Operario>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("operarios.xml");
            this.operarios = persistencia.lee();
            if (operarios == null) {
                operarios = new HashSet<>();
                operarios.add(Operario.administrador()); //cargar admin por default
                persistencia.escribir(operarios);
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.operarios = new HashSet<>();
            operarios.add(Operario.administrador());
            try {
                persistencia.escribir(operarios);
            } catch (IOException e) {}
        }
    }

    private void cargarComandasCerradas() {
        Ipersistencia<List<CierreComanda>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("cierres.xml");
            this.cierreComandas = persistencia.lee();
            if (cierreComandas == null) {
                cierreComandas = new ArrayList<>();
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.cierreComandas = new ArrayList<>();
            try {
                persistencia.escribir(cierreComandas);
            } catch (IOException e) {}
        }
    }

    private void cargarPromocionesFijas() {
        Ipersistencia<Set<PromocionFija>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("promocionesFijas.xml");
            this.promocionesFijas = persistencia.lee();
            if (promocionesFijas == null) {
                promocionesFijas = new HashSet<>();
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.promocionesFijas = new HashSet<>();
            try {
                persistencia.escribir(promocionesFijas);
            } catch (IOException e) {}
        }
    }

    private void cargarPromocionesTemporales() {
        Ipersistencia<Set<PromocionTemporal>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("promocionesTemporales.xml");
            this.promocionesTemporales = persistencia.lee();
            if (promocionesTemporales == null) {
                promocionesTemporales = new HashSet<>();
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.promocionesTemporales = new HashSet<>();
            try {
                persistencia.escribir(promocionesTemporales);
            } catch (IOException e) {}
        }
    }

    private void cargarProductos() {
        Ipersistencia<Set<Producto>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("productos.xml");
            this.productos = persistencia.lee();
            if (productos == null) {
                productos = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.productos = new HashSet<>();
        }
    }

    private void cargarMesas() {
        Ipersistencia<Set<Mesa>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("mesas.xml");
            this.mesas = persistencia.lee();
            if (mesas == null) {
                mesas = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.mesas = new HashSet<>();
        }
    }

    private void cargarMozos() {
        Ipersistencia<Set<Mozo>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("mozos.xml");
            this.mozos = persistencia.lee();
            if (mozos == null) {
                mozos = new HashSet<>();
            }
            persistencia.cerrarInput();
        } catch (Exception err) {
            this.mozos = new HashSet<>();
        }
    }


    public Operario login(String username, String password) throws CredencialesInvalidasException {
        Optional<Operario> logueado = operarios.stream()
                .filter(operario -> operario.getPassword().equals(password) && operario.getUsername().equals(username)).findFirst();

        if (logueado.isPresent()) {
            usuarioLogueado = logueado.get();
        } else {
            throw new CredencialesInvalidasException("Credenciales invalidas");
        }

        return usuarioLogueado;
    }

    public void logout() {
        usuarioLogueado = null;
    }
}
