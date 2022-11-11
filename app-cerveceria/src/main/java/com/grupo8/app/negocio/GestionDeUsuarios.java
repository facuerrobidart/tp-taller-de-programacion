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

    public Operario login(String username, String password) throws CredencialesInvalidasException {
        return this.empresa.login(username, password);
    }

    public void logout() {
        this.empresa.logout();
    }

    public void addOperario(AddOperarioRequest request) throws PermisoDenegadoException {
        if (this.empresa.getUsuarioLogueado().getUsername().equals("admin")) {
            this.empresa.getOperarios().add(
                    new Operario(request.getNombreCompleto(), request.getUsername(), request.getPassword()));
            persistirOperarios();
        } else {
            throw new PermisoDenegadoException("No tiene permisos para realizar esta accion");
        }
    }

    public MozoDTO addMozo(AddMozoRequest request) {
        Mozo nuevoMozo = new Mozo(request.getNombreCompleto(), request.getFechaNacimiento(), request.getCantidadHijos());
        this.empresa.getMozos().add(nuevoMozo);

        persistirMozo();
        return MozoDTO.of(nuevoMozo);
    }

    private void persistirMozo() {
        Ipersistencia<Set<Mozo>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mozos.xml");
            persistencia.escribir(this.empresa.getMozos());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    private void persistirOperarios() {
        Ipersistencia<Set<Operario>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("operarios.xml");
            persistencia.escribir(this.empresa.getOperarios());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public List<MozoDTO> obtenerMozos() {
        return this.empresa.getMozos()
                .stream().map(MozoDTO::of)
                .collect(Collectors.toList());
    }

    public List<OperarioDTO> obtenerOperarios() {
        return this.empresa.getOperarios()
                .stream().map(OperarioDTO::of)
                .collect(Collectors.toList());
    }
}
