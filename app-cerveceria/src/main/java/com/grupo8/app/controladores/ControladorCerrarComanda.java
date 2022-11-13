package com.grupo8.app.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.grupo8.app.dto.MozoDTO;
import com.grupo8.app.excepciones.MalaSolicitudException;
import com.grupo8.app.excepciones.NumeroMesaInvalidoException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.negocio.GestionDeMesas;
import com.grupo8.app.vistas.;

public class ControladorCerrarComanda implements ActionListener {

    private  vista;
    private Empresa empresa;
    private static ControladorCerrarComanda instancia = null;
    private GestionDeMesas gestionMesas;



    public ControladorCerrarComanda() {
        this.vista = new VistaCerrarComandas(null);
        this.empresa = Empresa.getEmpresa();
        this.vista.setActionListener(this);
        this.gestionMesas = new GestionDeMesas();
    }

    public static ControladorCerrarComanda getControladorCerrarComanda(boolean mostrar, Integer nroMesa) {
        if (instancia == null) {
            instancia = new ControladorCerrarComanda();
        }
         if (mostrar) {
            instancia.vista.mostrar();
        }
        return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

    }

}
