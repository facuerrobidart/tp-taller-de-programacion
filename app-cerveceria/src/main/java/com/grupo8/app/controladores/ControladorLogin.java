package com.grupo8.app.controladores;

import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.modelo.Operario;
import com.grupo8.app.vistas.ILogin;
import com.grupo8.app.vistas.VistaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener {
    private ILogin vista;
    private Operario logueado;
    private static  ControladorLogin instancia = null;
    private Empresa empresa;

    public ControladorLogin() {
        this.vista = new VistaLogin();
        this.logueado = null;
        this.empresa = Empresa.getEmpresa();
        this.vista.setActionListener(this);
    }

    public static ControladorLogin get(boolean mostrar) {
    	if(instancia == null) {
            instancia = new ControladorLogin();
        }
        if (mostrar) {
            instancia.vista.mostrar();
        }
    	return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "LOGIN":
                try {
                    this.logueado = empresa.login(vista.getUsername(), vista.getContrasena());
                } catch (Exception exception) {
                    vista.error("Error", "Usuario o contraseña incorrectos");
                    break;
                }
                if (logueado.getUsername().equals("admin")) {
                    this.vista.esconder();
                    ControladorSesionAdmin CAdmin = ControladorSesionAdmin.get(true);
                }
                break;
            case "SALIR":
                System.exit(0);
                break;
        }
    }

    public ILogin getVista() {
        return vista;
    }

}
