package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMesaRequest;
import com.grupo8.app.dto.AddMozoRequest;
import com.grupo8.app.dto.AddOperarioRequest;
import com.grupo8.app.dto.AddProductoRequest;
import com.grupo8.app.excepciones.CredencialesInvalidasException;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.excepciones.PermisoDenegadoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class GestionDeUsuarios {

    private Empresa empresa;

    public GestionDeUsuarios() {
        this.empresa = Empresa.getEmpresa();
    }

    public void login(String username, String password) throws CredencialesInvalidasException {
        this.empresa.login(username, password);
    }

    public void logout() {
        this.empresa.logout();
    }

    public void addOperario(AddOperarioRequest request) throws PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")) {
            this.empresa.getOperarios().add(
                    new Operario(request.getNombreCompleto(), request.getUsername(), request.getPassword()));

            Ipersistencia<Set<Operario>> persistencia = new PersistenciaXML();
            try {
                persistencia.abrirOutput("operarios.xml");
                persistencia.escribir(this.empresa.getOperarios());
                persistencia.cerrarOutput();
            } catch (Exception e) {
            }
        } else {
            throw new PermisoDenegadoException("No tiene permisos para realizar esta accion");
        }
    }

    public void addMozo(AddMozoRequest request) {
        this.empresa.getMozos().add(new Mozo(
                request.getNombreCompleto(), request.getFechaNacimiento(), request.getCantidadHijos()));

        Ipersistencia<Set<Mozo>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mozos.xml");
            persistencia.escribir(this.empresa.getMozos());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public void addMesa(AddMesaRequest request) throws NumeroMesaInvalidoException {

        Optional<Mesa> potencialDuplicado =
                this.empresa.getMesas().stream()
                        .filter(mesa -> Objects.equals(mesa.getNroMesa(), request.getNroMesa())).findFirst();

        if (!potencialDuplicado.isPresent()) {
            this.empresa.getMesas().add(new Mesa(request.getNroMesa(), request.getCantSillas()));

            Ipersistencia<Set<Mesa>> persistencia = new PersistenciaXML();
            try {
                persistencia.abrirOutput("mesas.xml");
                persistencia.escribir(this.empresa.getMesas());
                persistencia.cerrarOutput();
            } catch (Exception e) {
            }
        } else {
            throw new NumeroMesaInvalidoException("Ya existe una mesa con ese numero");
        }
    }

    public void addProducto(AddProductoRequest request) {
        this.empresa.getProductos().add(
                new Producto(request.getNombre(), request.getPrecio(), request.getCosto(), request.getStock()));

        Ipersistencia<Set<Producto>> ipersistencia = new PersistenciaXML();
        try {
            ipersistencia.abrirOutput("productos.xml");
            ipersistencia.escribir(this.empresa.getProductos());
            ipersistencia.cerrarOutput();
        } catch (Exception e) {
        }

    }
}
