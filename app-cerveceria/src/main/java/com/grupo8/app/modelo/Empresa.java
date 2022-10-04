package com.grupo8.app.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
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


    public static Empresa getEmpresa() {
        if (empresa == null) {
            empresa = new Empresa(nombre);
        }
        return empresa;
    }

    private Empresa() {
        this.mozos = new HashSet<Mozo>();
        this.mesas = new HashSet<Mesas>();
        this.productos = new HashSet<Producto>();
        this.operarios = new HashSet<Operario>();
    }
}
