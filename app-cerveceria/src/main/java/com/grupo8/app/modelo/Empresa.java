package com.grupo8.app.modelo;

import com.grupo8.app.excepciones.CredencialesInvalidasException;
import com.grupo8.app.modelo.Promociones.Promocion;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class Empresa {

    private static Empresa empresa;
    private String nombre;
    private Set<Mozo> mozos;
    private Set<Mesa> mesas;
    private Set<Producto> productos;
    private Set<Operario> operarios;
    private Set<Comanda> comandas;
    private Set<Promocion> promociones;
    private Operario usuarioLogueado;


    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    private Empresa() {
        cargarMesas();
        cargarMozos();
        cargarProductos();
        cargarOperarios();
        cargarComandas();
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

    private void cargarComandas() {
        Ipersistencia<Set<Comanda>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("operarios.xml");
            this.comandas = persistencia.lee();
            if (comandas == null) {
                comandas = new HashSet<>();
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.comandas = new HashSet<>();
            try {
                persistencia.escribir(comandas);
            } catch (IOException e) {}
        }
    }

    private void cargarPromociones() {
        Ipersistencia<Set<Promocion>> persistencia = new PersistenciaXML();

        try { // cargar los datos de la agencia desde el archivo XML
            persistencia.abrirInput("promociones.xml");
            this.promociones = persistencia.lee();
            if (promociones == null) {
                promociones = new HashSet<>();
            }

            persistencia.cerrarInput();
        } catch (Exception err) {
            this.promociones = new HashSet<>();
            try {
                persistencia.escribir(promociones);
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


    public void login(String username, String password) throws CredencialesInvalidasException {
        Optional<Operario> logueado = operarios.stream()
                .filter(operario -> operario.getPassword().equals(password) && operario.getUsername().equals(username)).findFirst();

        if (logueado.isPresent()) {
            usuarioLogueado = logueado.get();
        } else {
            throw new CredencialesInvalidasException("Credenciales invalidas");
        }
    }

    public void logout() {
        usuarioLogueado = null;
    }
}
