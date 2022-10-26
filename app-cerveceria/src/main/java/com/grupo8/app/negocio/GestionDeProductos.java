package com.grupo8.app.negocio;

import com.grupo8.app.dto.AddProductoRequest;
import com.grupo8.app.excepciones.EntidadNoEncontradaException;
import com.grupo8.app.modelo.Empresa;
import com.grupo8.app.modelo.Producto;
import com.grupo8.app.persistencia.Ipersistencia;
import com.grupo8.app.persistencia.PersistenciaXML;
import lombok.NonNull;

import java.util.Optional;
import java.util.Set;

public class GestionDeProductos {
    public Empresa empresa;

    public GestionDeProductos(Empresa empresa) {
        this.empresa = Empresa.getEmpresa();
    }

    public void addProducto(AddProductoRequest request) {
        this.empresa.getProductos().add(
                new Producto(request.getNombre(), request.getPrecio(), request.getCosto(), request.getStock()));
        persistir();
    }

    public void deleteProducto(@NonNull String id) {
        this.empresa.getProductos().removeIf(producto -> id.equals(producto.getId()));

        persistir();
    }

    public void editProducto(String id, AddProductoRequest informacion) throws EntidadNoEncontradaException {
        Optional<Producto> producto = this.empresa.getProductos().stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst();

        if (producto.isPresent()) {
            producto.get().update(informacion);
            persistir();
        } else {
            throw new EntidadNoEncontradaException("No se encontro el producto");
        }
    }

    private void persistir() {
        Ipersistencia<Set<Producto>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("productos.xml");
            persistencia.escribir(this.empresa.getProductos());
            persistencia.cerrarOutput();
        } catch (Exception e) {
        }
    }
}
