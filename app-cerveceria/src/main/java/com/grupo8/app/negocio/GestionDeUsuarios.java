package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMozoRequest;
import com.grupo8.app.dto.AddOperarioRequest;
import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.dto.OperarioDTO;
import com.grupo8.app.excepciones.CredencialesInvalidasException;
import com.grupo8.app.excepciones.PermisoDenegadoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GestionDeUsuarios {

    private Empresa empresa;

    public GestionDeUsuarios() {
        this.empresa = Empresa.getEmpresa();
    }

    /**
     * loguea un usuario
     * @param username nombre de usuario
     * @param password contraseña
     * @return Operario logueado
     * @throws CredencialesInvalidasException si las credenciales son incorrectas
     */
    public Operario login(String username, String password) throws CredencialesInvalidasException {
        return this.empresa.login(username, password);
    }

    /**
     * Desloguea un usuario
     */
    public void logout() {
        this.empresa.logout();
    }

    /**
     * Agrega un operario a la empresa y lo persiste
     * @param request DTO con los datos del operario a agregar
     * @throws PermisoDenegadoException si el usuario logueado no es administrador
     */
    public void addOperario(AddOperarioRequest request) throws PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")) {
            this.empresa.getOperarios().add(
                    new Operario(request.getNombreCompleto(), request.getUsername(), request.getPassword()));
            persistirOperarios();
        } else {
            throw new PermisoDenegadoException("No tiene permisos para realizar esta accion");
        }
    }

    /**
     * Agrega un mozo a la empresa y lo persiste
     * @param request DTO con los datos del mozo a agregar
     */
    public MozoDTO addMozo(AddMozoRequest request) {
        Mozo nuevoMozo = new Mozo(request.getNombreCompleto(), request.getFechaNacimiento(), request.getCantidadHijos());
        this.empresa.getMozos().add(nuevoMozo);

        persistirMozo();
        return MozoDTO.of(nuevoMozo);
    }

    /**
     * Persiste los mozos de la empresa en el archivo mozos.xml
     */
    private void persistirMozo() {
        Ipersistencia<Set<Mozo>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mozos.xml");
            persistencia.escribir(this.empresa.getMozos());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    /**
     * Persiste los operarios de la empresa en el archivo operarios.xml
     */
    private void persistirOperarios() {
        Ipersistencia<Set<Operario>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("operarios.xml");
            persistencia.escribir(this.empresa.getOperarios());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    /**
     * Obtiene los mozos de la empresa
     * @return lista de DTOs de mozos
     */
    public List<MozoDTO> obtenerMozos() {
        return this.empresa.getMozos()
                .stream().map(MozoDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene los operarios de la empresa
     * @return lista de DTOs de operarios
     */
    public List<OperarioDTO> obtenerOperarios() {
        return this.empresa.getOperarios()
                .stream().map(OperarioDTO::of)
                .collect(Collectors.toList());
    }
}
