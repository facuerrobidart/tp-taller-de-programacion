package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddMozoRequest;
import com.grupo8.app.dto.AddOperarioRequest;
import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.dto.OperarioDTO;
import com.grupo8.app.excepciones.CredencialesInvalidasException;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.excepciones.PermisoDenegadoException;
import com.grupo8.app.modelo.*;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import com.grupo8.app.tipos.EstadoMozo;
import com.grupo8.app.wrappers.MozoWrapper;
import com.grupo8.app.wrappers.OperariosWrapper;

import java.util.List;
import java.util.Optional;
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
            this.empresa.getOperarios().getOperarios().add(
                    new Operario(request.getNombreCompleto(), request.getUsername(), request.getPassword()));
            persistirOperarios();
        } else {
            throw new PermisoDenegadoException("No tiene permisos para realizar esta accion");
        }
    }

    public MozoDTO addMozo(AddMozoRequest request) {
        Mozo nuevoMozo = new Mozo(request.getNombreCompleto(), request.getFechaNacimiento(), request.getCantidadHijos());
        this.empresa.getMozos().getMozos().add(nuevoMozo);

        persistirMozo();
        return MozoDTO.of(nuevoMozo);
    }

    public void deleteMozo(MozoDTO mozo) {
        this.empresa.getMozos().getMozos().removeIf(m -> m.getId().equals(mozo.getId()));
        persistirMozo();
    }

    public void deleteMozoPorNombre(String nombre) {
        this.empresa.getMozos().getMozos().removeIf(m -> m.getNombreCompleto().contains(nombre));
        persistirMozo();
    }

    private void persistirMozo() {
        Ipersistencia<MozoWrapper> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mozos.xml");
            persistencia.escribir(this.empresa.getMozos());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    private void persistirOperarios() {
        Ipersistencia<OperariosWrapper> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("operarios.xml");
            persistencia.escribir(this.empresa.getOperarios());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }

    public List<MozoDTO> obtenerMozos() {
        return this.empresa.getMozos()
                .getMozos()
                .stream().map(MozoDTO::of)
                .collect(Collectors.toList());
    }

    public List<OperarioDTO> obtenerOperarios() {
        return this.empresa.getOperarios()
                .getOperarios()
                .stream().map(OperarioDTO::of)
                .collect(Collectors.toList());
    }

    public void tomarAsistencia(String id, EstadoMozo estado) throws EntidadNoEncontradaException {
        Optional<Mozo> mozo = this.empresa.getMozos().getMozos().stream().filter(m -> m.getId().equals(id)).findFirst();

        if (mozo.isPresent()) {
            mozo.get().setEstadoMozo(estado);
        } else {
            throw new EntidadNoEncontradaException("No se encontro el mozo con id " + id);
        }
    }
}
